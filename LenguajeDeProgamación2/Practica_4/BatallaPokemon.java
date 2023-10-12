public class BatallaPokemon {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 10);
        Pokemon Squirtle = new Pokemon("Squirtle", "Agua", 10);

        pikachu.atacar("Cola de hierro", Squirtle);
        Squirtle.atacar("Pistola Agua", pikachu);
    }
}