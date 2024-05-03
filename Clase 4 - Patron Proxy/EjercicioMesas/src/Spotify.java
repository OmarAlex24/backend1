public class Spotify implements ServicioDescarga{
    @Override
    public String descargar(Usuario usuario,String cancion) {
        System.out.println("Descargando canción: " + cancion);
        return "exito al descargar";
    }
}
