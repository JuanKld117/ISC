


public class Main {
    public static void main(String[] args) {
        PokemonAgua squirtle = new PokemonAgua("Squirtle", 10);
        PokemonFuego charmander = new PokemonFuego("Charmander", 12);

        squirtle.info();
        squirtle.atacar();
        squirtle.evolucionar();

        charmander.info();
        charmander.atacar();
        charmander.evolucionar();
    }
}