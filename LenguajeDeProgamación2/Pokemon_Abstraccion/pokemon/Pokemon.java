package pokemon;

public abstract class Pokemon {
    private int HP = 250;
    private final int nivel;
    private final String nombre;
    private Tipo tipo;
    private final Pokemon_Herencia.pokemon.Movimiento[] movimientos = new Pokemon_Herencia.pokemon.Movimiento[4];

    public Pokemon(String nombre, Tipo tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        for (int i = 0; i < movimientos.length; i++) {
            movimientos[i] = null;
        }
    }

    public int getHp() {
        return HP;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setMovimiento(int indice, Pokemon_Herencia.pokemon.Movimiento movimiento) {
        if (indice >= 0 && indice < movimientos.length) {
            movimientos[indice] = movimiento;
        }
    }

    public Pokemon_Herencia.pokemon.Movimiento getMovimiento(int indice) {
        if (indice >= 0 && indice < movimientos.length) {
            return movimientos[indice];
        }
        return null;
    }

    public abstract double obtenerEfectividad(Pokemon pokemon);

    private void calcularDanio(int danio, double efectividad) {
        double puntosRestados = danio * efectividad;
        this.HP -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de daño\n", this.getNombre(), puntosRestados);
    }

    public void recibirAtaque(Pokemon_Herencia.pokemon.Movimiento movimiento, double efectividad) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), movimiento.getNombre());
        calcularDanio(movimiento.getPuntosDeAtaque(), efectividad);
    }

    protected boolean seHaConcretadoAtaque(Pokemon_Herencia.pokemon.Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);

        if (movimiento.getPp() > 0) {
            pokemon.recibirAtaque(movimiento, efectividad);
            movimiento.setPp(movimiento.getPp() - 1);
            return true;
        } else {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int n, Pokemon pokemon) {
        Pokemon_Herencia.pokemon.Movimiento movimiento = getMovimiento(n);
        if (movimiento != null) {
            boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
            if (seHaConcretadoAtaque) {
                movimiento.setPp(movimiento.getPp() - 1);
            }
        } else {
            System.err.println("Movimiento no válido.");
        }
    }
}
