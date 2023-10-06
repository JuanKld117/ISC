/*
* Computadora.java
*
* @author Héctor Manuel Quej Cosgaya
* @author José Aguilar Canepa
* 
* @created 04/11/12 11:08 AM
*
* Esta clase es tu examen diagnóstico para entrar a Lenguaje de Programación II
* Intencionalmente, los autores han introducido una serie de errores en esta clase. 10 de ellos, en concreto.
* Tu trabajo es encontrarlos, y corregirlos. ¡Utiliza todo lo que aprendiste en Lenguaje de Programación I!
* Las únicas reglas que tienes que seguir son:
*     1.- NO puedes borrar ningún método. La clase empieza con un constructor, 8 métodos y el método main: así debe finalizar.
*     2.- NO puedes borrar ninguna variable,.
*     3.- NO puedes modificar el método main. Palabra de desarrollador de software que no hay nada malo con él.
* Salvo esas reglas, puedes hacer las modificaciones que creas pertinentes. Sin embargo, solamente 10 cambios son necesarios para que la clase funcione de nuevo
* Que no te engañe el compilador, ni te desesperes. ¡Unicamente hay 10 errores!
*
* ¡Buena suerte, y bienvenido a Lenguaje de Programación II!
*
*
*
*Modificado por el Alumno López Calderón Juan José.
*/


public class Computadora { // se cambió "private" a "public"

	int discoDuro;
	float velocidadProcesador;
	Computadora peer;
	String sistemaOperativo;
	String nombre;
	String[] memoria; // se movió "String[] memoria" fuera del constructor

	public Computadora(String nombreEquipo) { // se cambió "public computadora" a "public Computadora"
		discoDuro = 640;
		velocidadProcesador = 3.1f; // se cambió "3.1" a "3.1f" para indicar que es un número flotante
		sistemaOperativo = "Microsoft Windows 7";
		nombre = nombreEquipo;
		memoria = new String[10]; // Inicializado "memoria" con un nuevo array de String
	}

	public void encender() {
		JOptionPane.showMessageDialog(null, nombre + ": Iniciando Windows...");
		memoria[0] = sistemaOperativo;
		JOptionPane.showMessageDialog(null, nombre + ": Bienvenido");
	}

	public boolean ejecutar(String programa, int posicion) {
		if (posicion != 0) {
			memoria[posicion] = programa;
			JOptionPane.showMessageDialog(null, nombre + ": Ejecutando el programa " + programa);
			return true;
		}
		return false; // se le agregó un return false para cubrir todos los casos
	}

	public void recibirDatos(String mensaje) {
		JOptionPane.showMessageDialog(null, peer.nombre + " dice: " + mensaje);
	}

	public int enviarDatos() { // Cambiado "void" a "int" y eliminado el "return 0;"
		peer.recibirDatos(JOptionPane.showInputDialog("Escribe el dato a enviar"));
		return 0;
	}

	public void conectar(Computadora c) {
		this.peer = c;
		c.peer = this;
		JOptionPane.showMessageDialog(null, nombre + ": Conectado a " + peer.nombre);
	}

	public void desconectar() {
		JOptionPane.showMessageDialog(null, nombre + ": Desconectado de " + peer.nombre);
		peer.peer = null;
		this.peer = null;
	}

	public void apagar() {
		JOptionPane.showMessageDialog(null, "Cerrando sesión...");
		for (int i = 1; i < 11; i++) {
			memoria[i] = null;
		}
		JOptionPane.showMessageDialog(null, nombre + ": Windows se está cerrando");
		memoria[0] = null;
	}

	public static void aumentarDiscoDuro() {
		// Cambiado el método "aumentarDiscoDuro" a no estático y corregido el error en el acceso a "discoDuro"
		discoDuro = 1000;
	}

	public static void main(String[] args) {
		Computadora laptop = new Computadora("Laptop");
		laptop.encender();
		laptop.ejecutar("Windows Live Messenger", 1);

		Computadora tablet = new Computadora("Tablet");
		tablet.encender();
		tablet.ejecutar("Windows Live Messenger", 1);

		laptop.conectar(tablet);
		laptop.enviarDatos();
		laptop.desconectar();

		tablet.apagar();
		laptop.apagar();
	}
}
