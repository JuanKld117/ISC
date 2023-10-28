package pokemon.movimientos;

import pokemon.Tipo;

import java.util.ArrayList;

public class ListaMovimientos {

    private ArrayList<Movimientos> movimientos = new ArrayList<>();

    public ListaMovimientos() {
        movimientos.add(new Movimientos("Tormenta floral", 90, 15, Tipo.PLANTA, Clase.FISICO));
        movimientos.add(new Movimientos("Placaje", 40, 35, Tipo.NORMAL, Clase.FISICO));
        movimientos.add(new Movimientos("Danza pétalo", 20, 10, Tipo.PLANTA, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Latigo cepa", 45, 25, Tipo.PLANTA, Clase.FISICO));
        movimientos.add(new Movimientos("Rayo solar", 120, 10, Tipo.PLANTA, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Hiperrayo", 150, 5, Tipo.NORMAL, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Derribo", 90, 20, Tipo.NORMAL, Clase.FISICO));
        movimientos.add(new Movimientos("Colmillo igneo", 65, 15, Tipo.FUEGO, Clase.FISICO));
        movimientos.add(new Movimientos("Acrobata", 55, 15, Tipo.VOLADOR, Clase.FISICO));
        movimientos.add(new Movimientos("Giro fuego", 35, 15, Tipo.FUEGO, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Tajo aereo", 75, 15, Tipo.VOLADOR, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Ascuas", 40, 25, Tipo.FUEGO, Clase.ESPECIAL));
        movimientos.add(new Movimientos("Gruñido", 0, 40, Tipo.NORMAL, Clase.ESTADO));
        movimientos.add(new Movimientos("Pantalla de humo", 0, 20, Tipo.NORMAL, Clase.ESTADO));
        movimientos.add(new Movimientos("Desarrollo", 0, 20, Tipo.NORMAL, Clase.ESTADO));
        movimientos.add(new Movimientos("Desarrollo", 0, 20, Tipo.NORMAL, Clase.ESTADO));
        movimientos.add(new Movimientos("Drenadoras", 0, 10, Tipo.PLANTA, Clase.ESTADO));
        movimientos.add(new Movimientos("Polvo veneno", 0, 35, Tipo.VENENO, Clase.ESTADO));
    }

    public Movimientos buscarMovimientoPorNombre(String nombre) {
        for (Movimientos movimientosFisicos : this.movimientos) if (movimientosFisicos.getNombre().equals(nombre)) return movimientosFisicos;
        for (Movimientos movimientosEspeciales : this.movimientos) if (movimientosEspeciales.getNombre().equals(nombre)) return movimientosEspeciales;
        return null;
    }
}