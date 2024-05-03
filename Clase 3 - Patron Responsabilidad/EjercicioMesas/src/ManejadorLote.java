public class ManejadorLote extends Manejador{

    @Override
    public String comprobarCalidad(Articulo articulo) {
        if(articulo.getLote() >= 1000 && articulo.getLote() <= 2000){
            System.out.println("El articulo paso el estandar de Lote, pasando al siguiente control...");
            return getSiguienteManejador().comprobarCalidad(articulo);
        }
       return("El articulo no paso el control de lote");
    }
}
