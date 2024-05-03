package presencial;

public class ManejadorGerencial extends Manejador{

    @Override
        public String comprobarMail(Mail mail) {
            if(mail.getAsunto().equalsIgnoreCase("gerencia")
                    || mail.getDestino().equals("gerencia@lacolmena.com")){
                return "El departamento gerencial lo atendera, en unos momentos...";
            }
            System.out.println("No se pudo atender en gerencial, se derivara la consulta");
            return getSiguienteManejador().comprobarMail(mail);
        }
}
