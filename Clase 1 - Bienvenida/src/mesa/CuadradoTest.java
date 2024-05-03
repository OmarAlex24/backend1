package mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuadradoTest {

    @Test
    void calcularArea() {
        Cuadrado cuadrado = new Cuadrado(4);

        Assertions.assertEquals(16,cuadrado.calcularArea());
    }
}