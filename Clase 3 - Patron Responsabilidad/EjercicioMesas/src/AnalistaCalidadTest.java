import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnalistaCalidadTest {
    @Test
    public void envaseFallido(){
        AnalistaCalidad analista = new AnalistaCalidad();
        Articulo articulo = new Articulo("Pepsi", 1300,1200,"no sano");

        String respuestaEsperada = "El articulo no paso el control de Envasado";
        String respuestaActual = analista.validarCalidadDelProducto(articulo);

        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }

    @Test
    public void articuloExitoso(){
        AnalistaCalidad analista = new AnalistaCalidad();
        Articulo articulo = new Articulo("Pepsi", 1300,1200,"sano");

        String respuestaEsperada = "El articulo paso todos los controles";
        String respuestaActual = analista.validarCalidadDelProducto(articulo);

        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }
}