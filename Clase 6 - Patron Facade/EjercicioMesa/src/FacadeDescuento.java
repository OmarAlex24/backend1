public class FacadeDescuento implements IFacadeDescuento{
    private ApiCantidad apiCantidad;
    private ApiProducto apiProducto;
    private ApiTarjeta apiTarjeta;

    public FacadeDescuento(){
        apiCantidad = new ApiCantidad();
        apiProducto = new ApiProducto();
        apiTarjeta = new ApiTarjeta();
    }

    @Override
    public int descuento(Producto producto, Tarjeta tarjeta, int cantidad) {
        int descuento = 0;

        descuento += apiCantidad.descuentoCantidad(cantidad);
        descuento += apiProducto.descuentoProducto(producto);
        descuento += apiTarjeta.descuentoTarjeta(tarjeta);

        return descuento;
    }
}
