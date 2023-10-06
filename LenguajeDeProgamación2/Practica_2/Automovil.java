/**
 * Automovil.java
 *
 * Esta clase modela un Automovil y su funcionamiento básico.
 */
public class Automovil {

    int velocidad = 0;         // La velocidad a la que se desplaza el auto
    boolean motor = false;     // Representa si el motor está encendido (true) o apagado (false)
    String color;              // El color del auto
    String modelo;             // El modelo del auto
    static String marca;       // La marca del auto
    static int numeroDeAutos = 0; // La cantidad total de autos que se han creado

    /**
     * Inicializa un nuevo objeto Automovil.
     *
     * @param tono: El tono de color del automovil.
     * @param tipo: El nombre del modelo del automovil.
     */
    public Automovil(String tono, String tipo) {
        color = tono;
        modelo = tipo;
    }

    /**
     * Constructor que recibe un tercer argumento 'fabricante' y asigna el valor a 'marca'.
     */
    public Automovil(String tono, String tipo, String fabricante) {
        color = tono;
        modelo = tipo;
        marca = fabricante;
    }

    /**
     * Enciende el motor del automovil.
     */
    public void encenderMotor() {
        motor = true;
        System.out.println("Motor encendido");
    }

    /**
     * Apaga el motor del automovil.
     */
    public void apagarMotor() {
        motor = false;
        System.out.println("Motor apagado");
    }

    /**
     * Incrementa la velocidad del automovil en la cantidad de kilómetros/hora especificada.
     *
     * @param cantidad: El número de km/h en que aumentará la velocidad del auto.
     */
    public void acelerar(int cantidad) {
        if (motor) {
            velocidad += cantidad;
            System.out.println("Vamos a " + velocidad + " kph");
        } else {
            System.out.println("El motor está apagado!");
        }
    }

    /**
     * Reduce a cero la velocidad del auto.
     */
    public void frenar(int cantidad) {
        velocidad -= cantidad;
        if (velocidad < 0) velocidad = 0;
        System.out.println("Vamos a " + velocidad + " km/h");
    }

    /**
     * Nos muestra la velocidad a la que se está desplazando el auto.
     *
     * @return la velocidad del auto.
     */
    public int verVelocidad() {
        return velocidad;
    }

    /**
     * Duplica la velocidad recibida.
     *
     * @param velocidad: la velocidad que será duplicada.
     */
    public void duplicarVelocidad(int velocidad) {
        this.velocidad *= 2;
        System.out.println("Ahora vas a " + this.velocidad + " km/h!");
    }

    /**
     * Nos muestra la cantidad total de autos que se han creado a partir de la clase.
     *
     * @return el total de autos creados.
     */
    public static int verNumeroDeAutos() {
        return numeroDeAutos;
    }

    /**
     * Cambia el color del objeto 'auto' especificado a Negro.
     *
     * @param auto: La instancia de la clase Automovil cuyo color será cambiado.
     */
    public static void pintar(Automovil auto) {
        auto.color = "Negro";
    }

    /**
     * Constructor por defecto que utiliza autorreferencia.
     */
    public Automovil() {
        this(0, false, "Rojo", "Ford", "Fiesta");
    }

    /**
     * Constructor que recibe todos los atributos como argumentos.
     */
    public Automovil(int velocidad, boolean motor, String color, String marca, String modelo) {
        this.velocidad = velocidad;
        this.motor = motor;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        numeroDeAutos++;
    }

    /**
     * Clase anidada estática Estereo.
     */
    static class Estereo {
        public void reproducirCancion(String cancion) {
            System.out.println("Now playing... " + cancion);
        }
    }

    /**
     * Clase interna no estática Radiador.
     */
    class Radiador {
        public void enfriar() {
            if (motor) {
                System.out.println("Enfriando...");
            } else {
                System.out.println("No tengo nada que enfriar");
            }
        }
    }
}