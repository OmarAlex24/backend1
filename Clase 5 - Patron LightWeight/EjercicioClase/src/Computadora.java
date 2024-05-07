public class Computadora {
    private int ram;
    private int discoDuro;
    private static int contador;

    public Computadora(int ram, int discoDuro) {
        this.ram = ram;
        this.discoDuro = discoDuro;
        contador ++;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public static int getContador() {
        return contador;
    }
}
