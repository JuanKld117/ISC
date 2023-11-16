import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomáticoMain {

    public static void main(String[] args) {
        try {
            ejecutarCajeroAutomatico();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un formato de entrada válido.");
        } catch (Exception e) {
            System.out.println("Error inesperado. Por favor, vuelva a intentar.");
            e.printStackTrace();
        }
    }

    private static void ejecutarCajeroAutomatico() {
        Scanner scanner = new Scanner(System.in);
        CajeroAutomatico cajero = new CajeroAutomatico();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su NIP (4 dígitos): ");
        int nip = scanner.nextInt();

        if (nombre.equalsIgnoreCase("admin") && nip == 3243) {
            // Modo administrador
            while (true) {
                System.out.println("Modo Administrador:");
                System.out.println("1. Mostrar Acciones Guardadas");
                System.out.println("2. Mostrar Cantidad de Billetes");
                System.out.println("3. Salir del Modo Administrador");
                System.out.print("Seleccione una opción: ");
                int opcionAdmin = obtenerOpcionValida(scanner);

                switch (opcionAdmin) {
                    case 1:
                        ModoAdministrador.mostrarAccionesGuardadas();
                        break;
                    case 2:
                        ModoAdministrador.mostrarCantidadBilletes(cajero);
                        break;
                    case 3:
                        System.out.println("Saliendo del Modo Administrador.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                        break;
                }

                if (opcionAdmin == 3) {
                    break;
                }
            }
        } else {
            // Modo cajero
            Usuario usuario = new Usuario(nombre, nip);
            int saldoMinimo = 100;

            while (true) {
                System.out.println("Modo Cajero:");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Retirar Efectivo");
                System.out.println("3. Depositar");
                System.out.println("4. Salir del Cajero");
                System.out.print("Seleccione una opción: ");
                int opcionCajero = obtenerOpcionValida(scanner);

                switch (opcionCajero) {
                    case 1:
                        cajero.consultarSaldo(usuario);
                        Logger.logAccion("consultar", usuario.getNombre(), usuario.getSaldo(), true);
                        break;
                    case 2:
                        cajero.mostrarSaldoMinimo(saldoMinimo);
                        System.out.print("Ingrese la cantidad a retirar: ");
                        int cantidadRetiro = scanner.nextInt();
                        boolean retiroExitoso = cajero.retirarEfectivo(usuario, cantidadRetiro);
                        Logger.logAccion("retirar", usuario.getNombre(), cantidadRetiro, retiroExitoso);
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad a depositar: ");
                        int cantidadDeposito = scanner.nextInt();
                        cajero.depositar(usuario, cantidadDeposito);
                        break;
                    case 4:
                        System.out.println("Saliendo del Cajero.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción correcta.");
                        break;
                }

                if (opcionCajero == 4) {
                    break;
                }
            }
        }
    }

    private static int obtenerOpcionValida(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Ingrese un número entero válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
