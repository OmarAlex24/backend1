public class ManejadorPeso extends Manejador{
    @Override
    public String comprobarCalidad(Articulo articulo) {
        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300){
            System.out.println("El articulo paso el estandar de Peso, pasando al siguiente control...");
            return getSiguienteManejador().comprobarCalidad(articulo);
        }
        return("El articulo no paso el control de peso");
    }
}
