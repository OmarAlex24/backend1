package presencial;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class CompruebaMailTest {
    @Test
    public void mailASpam(){
        CompruebaMail laColmena = new CompruebaMail();
        Mail mail = new Mail("omarespinosafernandez@gmail.com", "jorgito","BackEnd 1");
        String respuestaEsperada = "Movido a SPAM";

        String respuestaActual = laColmena.disparadorCadena(mail);
        Assertions.assertEquals(respuestaEsperada,respuestaActual);

    }
}