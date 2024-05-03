public class EmpleadoInfantil extends Empleado{
    @Override
    public double calcularPrecio(Menu menu) {
        if(menu instanceof MenuInfantil){
            return menu.getPrecioBase() + ((MenuInfantil) menu).getCantidadJuguetes() * 3;
        }
        return 0;
    }

    @Override
    public String preparacion(Menu menu) {
        return "incluye "+((MenuInfantil)menu).getCantidadJuguetes()+" juguetes";
    }
}
