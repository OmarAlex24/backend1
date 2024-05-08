public class ApiProducto {
    public int descuentoProducto(Producto producto){
        if (producto.getTipo().equalsIgnoreCase("lata")){
            return 10;
        }

        return 0;
    }
}
