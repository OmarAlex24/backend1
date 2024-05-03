import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HolaMundoTest {

    @Test
    void saludar() {
        HolaMundo hola = new HolaMundo();
        Assertions.assertEquals("Hola Mundo!",hola.saludar());
    }
}