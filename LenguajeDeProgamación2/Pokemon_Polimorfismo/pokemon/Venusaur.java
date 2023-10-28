package pokemon;

import pokemon.movimientos.ListaMovimientos;

public class Venusaur extends Pokemon{
    public Venusaur(String nombre) {
        super(nombre, Tipo.PLANTA, Tipo.VENENO, 364, 289, 364, 291,
                328, 284);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Tormenta floral"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Placaje"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Danza pétalo"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Hoja afilada"));
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
            case AGUA: case ELECTRICO: case HADA: case LUCHA: efectividad *= 0.5; break;
            case FUEGO: case HIELO: case PSIQUICO: case VOLADOR: efectividad = 2; break;
            case PLANTA: efectividad *= 0.25; break;
        }
        return efectividad;
    }
    @Override public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad1 = calcularEfectividad(pokemon.getTipo());
        double efectividad2 = calcularEfectividad(pokemon.getTipo2());
        return efectividad1 + efectividad2;
    }
}
