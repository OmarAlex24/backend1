public abstract class Arbol {
    private String tipoDeArbol;
    private String color;
    private int alto;
    private int ancho;

    public String getTipoDeArbol() {
        return tipoDeArbol;
    }

    public void setTipoDeArbol(String tipoDeArbol) {
        this.tipoDeArbol = tipoDeArbol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
}
