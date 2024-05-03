import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;
import java.util.Date;

public class VacunatorioTest {

    @Test
    public void casoIncorrecto(){
            Persona persona = new Persona("AstraZeneca","Jorgito",111111,new Date(2024-1900, Calendar.MAY,3));
            VacunatorioProxy centro = new VacunatorioProxy();

            String respEsp = "Vuelva cuando sea su turno";
            String respAct = centro.vacunar(persona);

        Assertions.assertEquals(respEsp,respAct);
    }

    @Test
    public void casoCorrecto(){
        Persona persona = new Persona("AstraZeneca","Jorgito",111111,new Date(2024-1900, Calendar.MAY,1));
        VacunatorioProxy centro = new VacunatorioProxy();

        String respEsp = "";
        String respAct = centro.vacunar(persona);

        Assertions.assertEquals(respEsp,respAct);
    }
}