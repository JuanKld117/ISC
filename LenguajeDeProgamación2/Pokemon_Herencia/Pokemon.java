// Clase base Pokemon
class Pokemon {
    private String nombre;
    private int nivel;

    public Pokemon(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public void atacar() {
        System.out.println(nombre + " está atacando!");
    }

    public void evolucionar() {
        System.out.println(nombre + " está evolucionando a un nivel superior.");
    }

    public void info() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
    }
}
