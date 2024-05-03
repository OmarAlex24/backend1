package presencial;

public class CompruebaMail {
    private Manejador inicial;

    public CompruebaMail() {
        inicial = new ManejadorGerencial();
        Manejador tecnico = new ManejadorTecnico();
        Manejador comercial = new ManejadorComercial();
        Manejador spam = new ManejadorSpam();

        inicial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(spam);
    }

    public String disparadorCadena(Mail mail){
        return inicial.comprobarMail(mail);
    }
}
