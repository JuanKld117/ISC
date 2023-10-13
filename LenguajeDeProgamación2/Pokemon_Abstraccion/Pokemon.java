import java.util.Random;

public class Pokemon {
    private int HP;
    private final int nivel;
    private final String nombre;
    private final String tipo;

    public Pokemon(String nombre, String tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.HP = 100;
    }

    public int getHp() {
        return HP;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public int getNivel() {
        return nivel;
    }

    private void calculaDanio(int danio) {
        this.HP -= danio;
        System.out.printf("%s recibe %d puntos de daño\n", this.getNombre(), danio);
    }
    public void recibirAtaque(String movimiento) {
        int danio = new Random().nextInt(10) + 1;
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), movimiento);
        calculaDanio(danio);
        System.out.printf("%s tiene ahora %d puntos de vida\n", this.getNombre(), this.getHp());
    }
    public void atacar(String movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento);
        pokemon.recibirAtaque(movimiento);
    }
}
