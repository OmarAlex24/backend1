public class ManejadorEnvase extends Manejador{
    @Override
    public String comprobarCalidad(Articulo articulo) {
        if(articulo.getEnvasado().equalsIgnoreCase("sano") || articulo.getEnvasado().equalsIgnoreCase("casi sano")){
            System.out.println("El articulo paso el estandar de Envasado, paso todos los controles");
            return getSiguienteManejador().comprobarCalidad(articulo);
        }
        return("El articulo no paso el control de Envasado");
    }
}
