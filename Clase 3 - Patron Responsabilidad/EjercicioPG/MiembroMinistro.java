public class MiembroMinistro extends Miembro{
    @Override
    public String leerDocumento(Documento documento) {
        if(documento != null && documento.getTipo()  <= 2){
            System.out.println("El ministro esta leyendo el doc.");
            return "El ministro leyo el mensaje";
        }
        getSigMiembro().leerDocumento(documento);
        return "El ministro no pudo leer el mensaje";
    }
}
