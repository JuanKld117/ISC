package pokemon;

import pokemon.movimientos.Movimientos;

public interface PokemonInterface{
    public boolean seHaConcretadoAtaque(Pokemon pokemon, Movimientos ataque);
    public double obtenerBonificacion(Pokemon pokemon, Movimientos ataque);

}