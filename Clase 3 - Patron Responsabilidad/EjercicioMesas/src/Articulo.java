public class Articulo {
    private String nombre;
    private int lote;
    private int peso;
    private String envasado;

    public Articulo(String nombre, int lote, int peso, String envasado) {
        this.nombre = nombre;
        this.lote = lote;
        this.peso = peso;
        this.envasado = envasado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLote() {
        return lote;
    }

    public int getPeso() {
        return peso;
    }

    public String getEnvasado() {
        return envasado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setEnvasado(String envasado) {
        this.envasado = envasado;
    }
}
