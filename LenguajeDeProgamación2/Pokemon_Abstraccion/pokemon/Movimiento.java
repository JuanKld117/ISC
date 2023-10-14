// Clase Movimiento
package Pokemon_Herencia.pokemon;

import pokemon.Tipo;

public class Movimiento {
    private String nombre;
    private int puntosDeAtaque;
    private int pp;
    private Tipo tipo;

    public Movimiento(String nombre, int puntosDeAtaque, Tipo tipo, int pp) {
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.pp = pp;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
