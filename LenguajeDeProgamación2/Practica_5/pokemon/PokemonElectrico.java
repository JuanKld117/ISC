package Pokemon_Herencia.pokemon;

import pokemon.Pokemon;
import pokemon.Tipo;

public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, Tipo tipo, int nivel) {
        super(nombre, tipo, nivel);

        Pokemon_Herencia.pokemon.ListaMovimientos listaMovimientos = new Pokemon_Herencia.pokemon.ListaMovimientos();

        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Impactrueno"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Rayo"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Ataque Rápido"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Chispa"));
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        // Implementa la efectividad según el tipo del oponente
        return 1.0; // Valor predeterminado
    }
}
