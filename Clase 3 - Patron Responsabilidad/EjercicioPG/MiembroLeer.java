public class MiembroLeer {
    private Miembro inicial;

    public MiembroLeer() {
        inicial = new MiembroDiputado();
        Miembro ministro = new MiembroMinistro();
        Miembro presidente = new MiembroPresidente();

        inicial.setSigMiembro(ministro);
        ministro.setSigMiembro(presidente);

    }

    public String validarDocumento(Documento doc){ return inicial.leerDocumento(doc);}
}
