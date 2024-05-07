public class MiembroPresidente extends Miembro{

    @Override
    public String leerDocumento(Documento documento) {
        if(documento != null){
            System.out.println("El presidente esta leyendo el doc.");
            return "El presidente leyo el mensaje";
        }
        return "El presidente no pudo leer el mensaje";
    }
}
