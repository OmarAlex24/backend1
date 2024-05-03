import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoNormalTest {
    @Test
    public void prepararMenuNormal(){
        MenuNormal menuNormal1 = new MenuNormal(250);
        MenuNormal menuNormal2 = new MenuNormal(350.99);

        EmpleadoNormal empleadoNormal = new EmpleadoNormal();

        Assertions.assertEquals("El menu no incluye ningun extra, un total a pagar de: 250.0",empleadoNormal.prepararMenu(menuNormal1));
        Assertions.assertEquals("El menu no incluye ningun extra, un total a pagar de: 350.99",empleadoNormal.prepararMenu(menuNormal2));
    }
}