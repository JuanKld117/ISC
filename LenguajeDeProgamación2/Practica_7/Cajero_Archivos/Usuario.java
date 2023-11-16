import java.util.Random;

class Usuario {
    private String nombre;
    private int nip;
    private int saldo;

    private Random random = new Random();

    public Usuario(String nombre, int nip) {
        this.nombre = nombre;
        this.nip = nip;
        this.saldo = random.nextInt((50000 - 1000) + 1) + 1000;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNip() {
        return nip;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
