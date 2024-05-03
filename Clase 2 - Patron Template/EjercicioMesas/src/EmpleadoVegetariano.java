public class EmpleadoVegetariano extends Empleado{

    private double precioSalsas(Menu menu){
        return ((MenuVegetariano)menu).getSalsasVegetarianas() * 2;
    }

    private double precioEspecias(Menu menu){
        return (((MenuVegetariano)menu).getEspecias() / menu.getPrecioBase());
    }

    @Override
    public double calcularPrecio(Menu menu) {
        if(menu instanceof MenuVegetariano){
            return menu.getPrecioBase() + precioSalsas(menu)+ precioEspecias(menu) ;
        }
        return 0;
    }

    @Override
    public String preparacion(Menu menu) {
        return "incluye "+((MenuVegetariano)menu).getSalsasVegetarianas()+" salsa/s vegetariana/s"+
                " y "+((MenuVegetariano)menu).getEspecias()+" especia/s";
    }
}
