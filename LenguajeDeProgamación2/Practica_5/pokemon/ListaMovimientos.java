// Clase ListaMovimientos
package Pokemon_Herencia.pokemon;

import pokemon.Tipo;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Pokemon_Herencia.pokemon.Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {
        // Movimientos de tipo eléctrico
        movimientos.add(new Pokemon_Herencia.pokemon.Movimiento("Impactrueno", 40, Tipo.ELECTRICO, 30));
        movimientos.add(new Pokemon_Herencia.pokemon.Movimiento("Rayo", 90, Tipo.ELECTRICO, 15));

        // Movimientos de tipo agua
        movimientos.add(new Pokemon_Herencia.pokemon.Movimiento("Surf", 90, Tipo.AGUA, 15));
        movimientos.add(new Pokemon_Herencia.pokemon.Movimiento("Hidrobomba", 110, Tipo.AGUA, 10));

        // Agrega más movimientos aquí según los tipos de movimientos que desees
    }

    public Pokemon_Herencia.pokemon.Movimiento buscarMovimientoPorNombre(String nombre) {
        for (Pokemon_Herencia.pokemon.Movimiento movimiento : movimientos) {
            if (movimiento.getNombre().equals(nombre)) {
                return movimiento;
            }
        }
        return null;
    }
}
