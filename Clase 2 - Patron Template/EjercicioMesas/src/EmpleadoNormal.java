public class EmpleadoNormal extends Empleado{
    @Override
    public double calcularPrecio(Menu menu) {
        if(menu instanceof MenuNormal){
            return menu.getPrecioBase();
        }
        return 0;
    }

    @Override
    public String preparacion(Menu menu) {
        return "no incluye ningun extra";
    }
}
