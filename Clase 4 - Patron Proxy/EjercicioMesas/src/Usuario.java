public class Usuario {

    public enum TipoUsuario{
        Premium,Free;
    }

    private String id;
    private TipoUsuario tipo;

    public Usuario(String id, TipoUsuario tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
}
