/**
 * Editado por -JJLC-
 */

public class TesterFord {
    public static void main(String[] args) {
        AutomovilFord auto = new AutomovilFord();
        auto.encenderMotor();
        System.out.println("El auto " + auto.marca + " " + auto.modelo + " " + auto.color + " ha sido creado!");
        while (auto.getVelocidad() < 200) {
            auto.acelerar();
        }
        auto.frenar(6000);
    }
}
