package presencial;

public class Mail {
    private String origen, destino, asunto;

    public Mail(String origen, String destino, String asunto) {
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getAsunto() {
        return asunto;
    }
}
