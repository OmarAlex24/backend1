package presencial;

public class ManejadorSpam extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        System.out.println("Finalmente no se pudo manejar la solicitud");
        return "Movido a SPAM";
    }
}
