package pokemon;

import pokemon.movimientos.ListaMovimientos;

public class Charizard extends Pokemon {
    public Charizard(String nombre) {
        super(nombre, Tipo.FUEGO, Tipo.VOLADOR, 360, 293, 280, 348, 295, 328);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Tajo aereo"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Arañazo"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Ascuas"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Onda ignea"));
    }

    public double calcularEfectividad(Tipo tipo) {
        double efectividad = 1;
        ///Si la debilidad es 0, el daño será neutro y se multiplicarán por 1.
        // Si la debilidad es elevada, el daño se multiplica por 4.
        // Si la debilidad es normal, el daño se multiplica por 2.
        // Si la resistencia es normal, el daño se divide entre 2.
        // Si la resistencia es elevada, el daño se divide entre 4.
        // Si es inmune, el daño se multiplica por 0
        switch (tipo) {
            case ACERO:
            case FUEGO:
            case HADA:
            case LUCHA:
                efectividad *= 0.5;
                break;
            case AGUA:
            case ELECTRICO:
                efectividad *= 2;
                break;
            case BICHO:
            case PLANTA:
                efectividad *= 0.25;
                break;
            case ROCA:
                efectividad *= 4;
                break;
            case TIERRA:
                efectividad *= 0;
                break;
        }
        return efectividad;
    }

    @Override
    public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad1 = calcularEfectividad(pokemon.getTipo());
        double efectividad2 = calcularEfectividad(pokemon.getTipo2());
        return efectividad1 + efectividad2;
    }
}
