
// Clase derivada para Pokémon de tipo Fuego
class PokemonFuego extends Pokemon {
    public PokemonFuego(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " está usando un ataque de fuego.");
    }

    private boolean getNombre() {
        return false;
    }
}
