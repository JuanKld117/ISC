import pokemon.*;

public class BatallaPokemon {
    public static void iniciarBatalla(Pokemon Charizard, Pokemon Venusaur) {
        System.out.println("Batalla entre " + Charizard.getNombre() + " y " + Venusaur.getNombre());

        while((Charizard.getHp() > 0 && Venusaur.getHp() > 0)) {
            realizarAtaque(Charizard, 0, Venusaur);
            realizarAtaque(Venusaur, 1, Charizard);
        }
        determinarGanador(Charizard, Venusaur);
    }

    public static void realizarAtaque(Pokemon atacante, int movimiento, Pokemon defensor) {
        atacante.atacar(movimiento, defensor);
        System.out.println(atacante.getNombre() + " HP = " + atacante.getHp());
    }


    public static void determinarGanador(Pokemon Charizard, Pokemon Venusaur) {
        if (Charizard.getHp() <= 0) {
            System.out.println(Charizard.getNombre() + " ha perdido la batalla.");
        } else {
            System.out.println(Venusaur.getNombre() + " ha perdido la batalla.");
        }
    }
    public static void main(String[] args) {
        Pokemon charizard = new Charizard("Charizard");
        Pokemon venusaur = new Venusaur("Venusaur");
        iniciarBatalla(charizard, venusaur);
    }
}