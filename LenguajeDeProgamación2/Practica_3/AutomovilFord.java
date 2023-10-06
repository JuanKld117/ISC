public class AutomovilFord {
    int velocidad;
    String color;
    public String modelo;
    Motor motor;
    public static final String marca = "Ford";

    public AutomovilFord(String modelo, String color) {
        this.modelo = modelo;
        this.color = color;
        velocidad = 0;
        motor = new Motor();
    }

    public AutomovilFord() {
        this("EcoSport", "Azul");
    }

    public void encenderMotor() {
        motor.setEncendido(true); // Usamos el setter
        System.out.println("Motor encendido");
    }

    public void apagarMotor() {
        motor.setEncendido(false); // Usamos el setter
        System.out.println("Motor apagado");
    }

    public void acelerar() {
        if (motor.isEncendido()) { // Usamos el getter
            motor.comprimirMezcla();
            motor.encenderMezcla();
            motor.prepararMezcla();
            velocidad = (motor.getRevoluciones() / 100); // Usamos el getter
            System.out.println("Vamos a " + velocidad + " kph");
        } else {
            System.out.println("El motor está apagado!");
        }
    }

    public void frenar(int i) { // Quitamos el parámetro, ya que el método no acepta argumentos
        if (velocidad < 0) velocidad = 0;
        System.out.println("Vamos a " + velocidad + " kph");
    }

    public int getVelocidad() {
        return velocidad;
    }
}
