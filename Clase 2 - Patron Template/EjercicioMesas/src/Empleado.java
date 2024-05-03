public abstract class Empleado {

    public String prepararMenu(Menu menu){
        String resp = "No se pudo preparar el menu";
        double precio = calcularPrecio(menu);

        if(precio > 0){
            String preparacion = preparacion(menu);
            resp = "El menu "+preparacion+", un total a pagar de: "+precio;
        }
        return resp;
    }

    public abstract double calcularPrecio(Menu menu);
    public abstract String preparacion(Menu menu);
}
