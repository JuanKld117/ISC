package pokemon;

import pokemon.movimientos.Movimientos;

public abstract class Pokemon implements PokemonInterface {
    private int hp, nivel, variacion, puntosDefensa, puntosAtaque, puntosAtaqueEspecial, puntosDefensaEspecial, velocidad;
    private String nombre;
    private Tipo tipo, tipo2;
    private Movimientos[] movimientos;

    public Pokemon(String nombre, Tipo tipo, Tipo tipo2, int hp, int puntosAtaque, int puntosDefensa,
                   int puntosAtaqueEspecial, int puntosDefensaEspecial, int velocidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipo2 = tipo2;
        this.nivel = 100;
        this.hp = hp;
        this.movimientos = new Movimientos[12];
        this.variacion = 85;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.puntosAtaqueEspecial = puntosAtaqueEspecial;
        this.puntosDefensaEspecial = puntosDefensaEspecial;
        this.velocidad = velocidad;
    }

    public int getHp() {
        return hp;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public int getNivel() {
        return nivel;
    }

    public void calculaDanio(Pokemon pokemon, Movimientos ataque) {
        this.hp -= (int) ataque.calcularMovimiento(pokemon, ataque);
        System.out.printf("%s recibe %.2f puntos de daño\n", this.getNombre(), ataque.calcularMovimiento(pokemon, ataque));
    }

    public void recibirAtaque(Pokemon pokemon, Movimientos ataque) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), ataque.getNombre());
        calculaDanio(pokemon, ataque);
    }

    @Override
    public boolean seHaConcretadoAtaque(Pokemon pokemon, Movimientos ataque) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(), ataque.getNombre());
        if ((ataque.getPuntosPoder() > 0) && (pokemon.getHp() > 0)) {
            pokemon.recibirAtaque(pokemon, ataque);
            return true;
        } else if ((ataque.getPuntosPoder() > 0) && (pokemon.getHp() == 0)) {
            System.err.println(("Tu pokemon ha perdido la batalla"));
            return false;
        } else if ((ataque.getPuntosPoder() == 0) && (pokemon.getHp() > 0)) {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        } else {
            return false;
        }
    }

    public abstract double obtenerEfectividad(Pokemon pokemon);

    public void atacar(int a, Pokemon pokemon) {
        Movimientos ataque = getMovimiento(a);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(pokemon, ataque);
        if (seHaConcretadoAtaque) {
            this.getMovimiento(a).setPuntosPoder(ataque.getPuntosPoder() - 1);
        }
    }

    public void setMovimiento(int indice, Movimientos movimientos) {
        this.movimientos[indice] = movimientos;
    }

    public Movimientos getMovimiento(int indice) {
        return movimientos[indice];
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public int getPuntosAtaqueEspecial() {
        return puntosAtaqueEspecial;
    }
    public int getPuntosDefensaEspecial() {
        return puntosDefensaEspecial;
    }

    public  int getVariacion() {
        return variacion;
    }

    public int getVelocidad() {
        return velocidad;
    }


    @Override 
    public double obtenerBonificacion(Pokemon pokemon, Movimientos movimiento) {
/*        Tipo tipoPokemon = pokemon.getTipo();
        Tipo tipoPokemon2 = pokemon.getTipo2();
        Tipo tipoAtaque = movimiento.getTipo();
        if (tipoPokemon.equals(tipoAtaque)) return 1.5;
        else if(tipoPokemon2.equals(tipoAtaque)) return 1.5;
        else return 1.0;*/
        return 1.0;
    }
}
