public class MiembroDiputado extends Miembro{
    @Override
    public String leerDocumento(Documento documento) {
        if(documento != null && documento.getTipo() == 1){
            System.out.println("El diputado esta leyendo el doc.");
            return "El diputado leyo el mensaje";
        }
        getSigMiembro().leerDocumento(documento);
        return "El diputado no pudo leer el documento";
    }
}
