package pokemon.movimientos;

import pokemon.*;

public class Movimientos {
    private String nombre;
    private int puntosPoder, puntosDeAtaque;
    private Tipo tipo;
    private Clase clase;

    public Movimientos(String nombre, int puntosPoder, Tipo tipo, Clase clase) {
        this.nombre = nombre;
        this.puntosPoder = puntosPoder;
        this.tipo = tipo;
        this.clase = clase;
    }

    public Movimientos(String nombre, int puntosDeAtaque, int puntosPoder, Tipo tipo, Clase clase) {
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.puntosPoder = puntosPoder;
        this.tipo = tipo;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosPoder() {
        return puntosPoder;
    }

    public void setPuntosPoder(int puntosPoderAtaque) {
        this.puntosPoder = puntosPoderAtaque;
    }

    public Tipo getTipo() {
        return tipo; 
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public double calcularMovimiento(Pokemon pokemon, Movimientos movimiento) {
        double bonificacion = pokemon.obtenerBonificacion(pokemon, movimiento);
        double efectividad = pokemon.obtenerEfectividad(pokemon);
        double dannio = 0;
        switch (clase) {
            case ESPECIAL:
                dannio = (0.01 * bonificacion * efectividad * pokemon.getVariacion()) * (((0.2 * pokemon.getNivel() + 1) * pokemon.getPuntosAtaqueEspecial() * movimiento.getPuntosDeAtaque()) / (25 * pokemon.getPuntosDefensa())) + (2);
                break;
            case FISICO:
                dannio = (0.01 * bonificacion * efectividad * pokemon.getVariacion()) * (((0.2 * pokemon.getNivel() + 1)  * pokemon.getPuntosAtaque() * movimiento.getPuntosDeAtaque()) / (25 * pokemon.getPuntosDefensa())) + (2);
                break;
        }
        return dannio;
    }
}

