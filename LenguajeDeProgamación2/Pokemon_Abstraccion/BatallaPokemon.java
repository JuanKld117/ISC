package Pokemon_Herencia.pokemon;

import pokemon.Pokemon;
import pokemon.Tipo;

public class BatallaPokemon {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon_Herencia.pokemon.PokemonElectrico("Pikachu", Tipo.ELECTRICO, 10);
        Pokemon squirtle = new Pokemon_Herencia.pokemon.PokemonAgua("Squirtle", Tipo.AGUA, 10);

        pikachu.atacar(0, squirtle); // Cambia el valor 0 por el índice del movimiento que desees
        squirtle.atacar(1, pikachu); // Cambia el valor 1 por el índice del movimiento que desees
    }
}
