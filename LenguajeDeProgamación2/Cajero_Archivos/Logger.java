import java.io.*;
import java.util.*;

class Logger {
    private static final String LOG_FILE = "logs.txt";

    public static void logAccion(String accion, String usuario, int saldo, boolean seRealizo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(accion + "," + usuario + "," + saldo + "," + (seRealizo ? "SI" : "NO"));
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de logs.");
        }
    }

    public static List<String> obtenerAccionesGuardadas() {
        List<String> acciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                acciones.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de logs.");
        }
        return acciones;
    }
}
