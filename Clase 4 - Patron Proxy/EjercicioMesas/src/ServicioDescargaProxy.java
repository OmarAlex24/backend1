public class ServicioDescargaProxy implements ServicioDescarga {

    private Spotify spotify;

    public ServicioDescargaProxy() {
        spotify = new Spotify();
    }

    @Override
    public String descargar(Usuario usuario, String cancion) {
        if (usuario.getTipo() == Usuario.TipoUsuario.Premium) {
            return spotify.descargar(usuario,cancion);
        }
            return "Lo siento, esta funcionalidad solo está disponible para usuarios premium.";

    }
}
