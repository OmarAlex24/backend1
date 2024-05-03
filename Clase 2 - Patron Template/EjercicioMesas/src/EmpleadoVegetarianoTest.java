import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoVegetarianoTest {
    @Test
    public void prepararMenuVegetariano(){
        MenuVegetariano menuVegetariano1 = new MenuVegetariano(250,2,2);
        MenuVegetariano menuVegetariano2 = new MenuVegetariano(250,0,0);

        EmpleadoVegetariano empleadoVegetariano = new EmpleadoVegetariano();

        Assertions.assertEquals("El menu incluye 2 salsa/s vegetariana/s y 2 especia/s, un total a pagar de: 254.008",empleadoVegetariano.prepararMenu(menuVegetariano1));
        Assertions.assertEquals("El menu incluye 0 salsa/s vegetariana/s y 0 especia/s, un total a pagar de: 250.0",empleadoVegetariano.prepararMenu(menuVegetariano2));
    }
}