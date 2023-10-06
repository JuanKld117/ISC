public class ControladorAutomovil {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Ford", "Fiesta");
        auto.encenderMotor();
        auto.acelerar(50);
        auto.frenar(20); // Modificamos la llamada al método frenar() con un valor
        System.out.println("El auto se mueve a " + auto.verVelocidad() + " km/h");
        auto.color = "Rojo";
        System.out.println("Mi auto es de color " + auto.color);
        // Paso por referencia
        Automovil.pintar(auto);
        System.out.println("El color de mi auto ahora es " + auto.color);


        auto.acelerar(50);
        // Paso por valor
        auto.duplicarVelocidad(auto.verVelocidad());
        System.out.println("El auto se mueve a " + auto.verVelocidad() + " km/h");
        auto.color = "Rojo";
        System.out.println("Mi auto es de color " + auto.color);
        // Paso por referencia
        Automovil.pintar(auto);
        System.out.println("El color de mi auto ahora es " + auto.color);


        // Creación de objetos Estereo y Radiador
        Automovil.Estereo radio = new Automovil.Estereo();
        radio.reproducirCancion("Guns n' Roses - Nightrain");

        Automovil.Radiador radiador = auto.new Radiador();
        radiador.enfriar();
    }
}