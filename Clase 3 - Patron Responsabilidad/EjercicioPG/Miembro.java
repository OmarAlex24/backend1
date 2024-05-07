public abstract class Miembro {
    private Miembro sigMiembro;

    public Miembro getSigMiembro() {
        return sigMiembro;
    }

    public void setSigMiembro(Miembro sigMiembro) {
        this.sigMiembro = sigMiembro;
    }

    public abstract String leerDocumento(Documento documento);
}
