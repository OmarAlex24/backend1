public class ManejadorExitoso extends Manejador{
    @Override
    public String comprobarCalidad(Articulo articulo) {
        System.out.println("El articulo completo todos lo controles");
        return("El articulo paso todos los controles");
    }
}
