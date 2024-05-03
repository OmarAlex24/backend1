package presencial;

public class ManejadorComercial extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        if(mail.getAsunto().equalsIgnoreCase("comercial")
                || mail.getDestino().equals("comercial@lacolmena.com")){
            return "El departamento comercial lo atendera, en unos momentos...";
        }
        System.out.println("No lo pudo atender el departamento comercial, se derivara la consulta");
        return getSiguienteManejador().comprobarMail(mail);
    }
}
