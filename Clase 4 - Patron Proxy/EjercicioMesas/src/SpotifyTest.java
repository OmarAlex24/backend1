import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class SpotifyTest {
    @Test
    public void testDescargarFree() {
        Usuario usuario = new Usuario("789", Usuario.TipoUsuario.Free);
        ServicioDescargaProxy proxy = new ServicioDescargaProxy();

        String respuestaEsperada = "Lo siento, esta funcionalidad solo está disponible para usuarios premium.";
        String respuestaActual = proxy.descargar(usuario,"CancionFree.mp3");

        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }

    @Test
    public void testDescargarPremium() {
        Usuario usuario = new Usuario("789", Usuario.TipoUsuario.Premium);
        ServicioDescargaProxy proxy = new ServicioDescargaProxy();

        String respuestaEsperada = "exito al descargar";
        String respuestaActual = proxy.descargar(usuario,"CancionFree.mp3");

        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }
}