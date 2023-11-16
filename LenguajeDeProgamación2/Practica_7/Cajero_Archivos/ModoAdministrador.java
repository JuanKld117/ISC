import java.util.*;

class ModoAdministrador {

    public static void mostrarAccionesGuardadas() {
        List<String> acciones = Logger.obtenerAccionesGuardadas();
        if (acciones.isEmpty()) {
            System.out.println("No hay acciones guardadas.");
        } else {
            System.out.println("Acciones guardadas:");
            for (String accion : acciones) {
                System.out.println(accion);
            }
        }
    }

    public static void mostrarCantidadBilletes(CajeroAutomatico cajero) {
        Map<Integer, Integer> billetes = cajero.getBilletes();
        if (billetes.isEmpty()) {
            System.out.println("No hay billetes disponibles en el cajero.");
        } else {
            System.out.println("Cantidad de billetes restantes en el cajero:");
            for (Map.Entry<Integer, Integer> entry : billetes.entrySet()) {
                System.out.println("$" + entry.getKey() + ": " + entry.getValue() + " billetes");
            }
        }
    }
}
