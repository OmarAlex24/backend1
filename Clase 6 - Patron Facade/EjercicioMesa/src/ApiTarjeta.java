public class ApiTarjeta {
    public int descuentoTarjeta(Tarjeta tarjeta){
        if(tarjeta.getNombre().equalsIgnoreCase("star bank")){
            return 20;
        }
        return 0;
    }
}
