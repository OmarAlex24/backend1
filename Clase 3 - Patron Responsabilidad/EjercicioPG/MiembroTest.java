import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class MiembroTest {

    @Test
    public void todosValidos(){
        MiembroLeer validar = new MiembroLeer();
        Documento documento = new Documento("Hola mundo!",1);

        String respuestaEsperada = "El presidente pudo leer el documento";
        String respuestaActual = validar.validarDocumento(documento);

        Assertions.assertEquals(respuestaEsperada,respuestaActual);
    }
}