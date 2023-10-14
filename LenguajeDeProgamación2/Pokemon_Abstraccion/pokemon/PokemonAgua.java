package Pokemon_Herencia.pokemon;

import pokemon.Pokemon;
import pokemon.Tipo;

public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nombre, Tipo tipo, int nivel) {
        super(nombre, tipo, nivel);

        Pokemon_Herencia.pokemon.ListaMovimientos listaMovimientos = new Pokemon_Herencia.pokemon.ListaMovimientos();

        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Surf"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Hidrobomba"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Chorro de Agua"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Rayo Burbuja"));
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        // Implementa la efectividad según el tipo del oponente
        return 1.0; // Valor predeterminado
    }
}
