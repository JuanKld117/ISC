package pokemon;

public class PokemonTipo extends Pokemon {
    public PokemonTipo(String nombre, Tipo tipo, int nivel) {
        super(nombre, tipo, nivel);
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        // Implementa la efectividad según el tipo del oponente
        return 1.0; // Valor predeterminado
    }
}
