package mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    @Test
    void calcularArea() {
        Circulo circulo = new Circulo(4);

        Assertions.assertEquals(1, circulo.calcularArea());

        Assertions.assertEquals(Math.PI*Math.pow(4,2), circulo.calcularArea());
    }
}