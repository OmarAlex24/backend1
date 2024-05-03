public class AnalistaCalidad {
    private Manejador inicial;

    public AnalistaCalidad() {
        inicial = new ManejadorLote();
        Manejador peso = new ManejadorPeso();
        Manejador envase = new ManejadorEnvase();
        Manejador exitoso = new ManejadorExitoso();

        inicial.setSiguienteManejador(peso);
        peso.setSiguienteManejador(envase);
        envase.setSiguienteManejador(exitoso);
    }

    public String validarCalidadDelProducto(Articulo articulo){
        return inicial.comprobarCalidad(articulo);
    }
}
