import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoInfantilTest {
    @Test
    public void prepararMenuInfantil(){
        MenuInfantil menuInfantil1 = new MenuInfantil(250,2);
        MenuInfantil menuInfantil2 = new MenuInfantil(250,0);

        EmpleadoInfantil empleadoInfantil = new EmpleadoInfantil();

        Assertions.assertEquals("El menu incluye 2 juguetes, un total a pagar de: 256.0",empleadoInfantil.prepararMenu(menuInfantil1));
        Assertions.assertEquals("El menu incluye 0 juguetes, un total a pagar de: 250.0",empleadoInfantil.prepararMenu(menuInfantil2));
    }
}