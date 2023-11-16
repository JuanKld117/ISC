import java.io.*;
import java.util.*;

public class CajeroAutomatico {
    private Map<Integer, Integer> billetes;

    public CajeroAutomatico() {
        this.billetes = cargarBilletesDesdeArchivo();
        if (billetes.isEmpty()) {
            inicializarBilletes();
            guardarBilletesEnArchivo();
        }
    }

    public Map<Integer, Integer> getBilletes() {
        return billetes;
    }

    public void mostrarSaldoMinimo(int saldoMinimo) {
        System.out.println("Monto mínimo a retirar: $" + saldoMinimo);
    }

    public void consultarSaldo(Usuario usuario) {
        System.out.println("Saldo actual de " + usuario.getNombre() + ": $" + usuario.getSaldo());
    }

    public boolean retirarEfectivo(Usuario usuario, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad ingresada no es válida. Intente nuevamente.");
            return false;
        }

        if (usuario.getSaldo() < cantidad) {
            System.out.println("Saldo insuficiente para realizar el retiro.");
            return false;
        }

        if (!haySuficientesBilletes(cantidad)) {
            System.out.println("No hay suficientes billetes para realizar el retiro. Intente con otra cantidad.");
            return false;
        }

        usuario.setSaldo(usuario.getSaldo() - cantidad);
        descontarBilletes(cantidad);
        System.out.println("Retiro exitoso. Nuevo saldo: $" + usuario.getSaldo());

        guardarBilletesEnArchivo();
        return true;
    }

    public void depositar(Usuario usuario, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad ingresada no es válida. Intente nuevamente.");
            return;
        }

        usuario.setSaldo(usuario.getSaldo() + cantidad);
        System.out.println("Depósito exitoso. Nuevo saldo: $" + usuario.getSaldo());
        Logger.logAccion("depositar", usuario.getNombre(), cantidad, true);
    }

    private boolean haySuficientesBilletes(int cantidad) {
        int[] denominaciones = {100, 200, 500, 1000};

        for (int denominacion : denominaciones) {
            int cantidadBilletes = billetes.getOrDefault(denominacion, 0);
            int billetesNecesarios = cantidad / denominacion;

            if (billetesNecesarios > cantidadBilletes) {
                return false;
            }

            cantidad %= denominacion;
        }

        return cantidad == 0;
    }

    private void descontarBilletes(int cantidad) {
        int[] denominaciones = {100, 200, 500, 1000};

        for (int denominacion : denominaciones) {
            int billetesNecesarios = cantidad / denominacion;

            if (billetesNecesarios > 0) {
                billetes.put(denominacion, billetes.get(denominacion) - billetesNecesarios);
                cantidad %= denominacion;
            }
        }
    }

    private void inicializarBilletes() {
        billetes = new HashMap<>();
        billetes.put(100, 100);
        billetes.put(200, 100);
        billetes.put(500, 20);
        billetes.put(1000, 10);
    }

    private Map<Integer, Integer> cargarBilletesDesdeArchivo() {
        Map<Integer, Integer> billetesCargados = new HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("billetes.dat"))) {
            billetesCargados = (Map<Integer, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Ignorar errores al leer el archivo
        }

        return billetesCargados;
    }

    private void guardarBilletesEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("billetes.dat"))) {
            oos.writeObject(billetes);
        } catch (IOException e) {
            System.out.println("Error al guardar la información de los billetes en el archivo.");
        }
    }
}
