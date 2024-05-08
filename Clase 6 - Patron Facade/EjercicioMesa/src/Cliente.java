public class Cliente {
    public static void main(String[] args) {
        FacadeDescuento fachada = new FacadeDescuento();

        Tarjeta tarjeta = new Tarjeta(11111, "star bank");
        Producto producto = new Producto("Tomates", "lata");
        int cantidad = 12;

        System.out.println("Descuento acumulado: "+fachada.descuento(producto,tarjeta,cantidad));

    }
}
