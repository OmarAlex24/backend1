package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GrupoTest {

    @Test
    public void agregar2Persona(){
        Persona persona1 = new Persona("Juan", 18);
        Persona persona2 = new Persona("Pedro", 17);
        Persona persona3 = new Persona("Ana", 22);
        Persona persona4 = new Persona("Luz", 14);
        Persona persona5 = new Persona("Julian",32);

        Grupo grupo = new Grupo();

        grupo.agregarPersona(persona1);
        grupo.agregarPersona(persona2);
        grupo.agregarPersona(persona3);
        grupo.agregarPersona(persona4);
        grupo.agregarPersona(persona5);

        int valorEsperado = 2;
        int valorActual = grupo.getListaPersonas().size();

        Assertions.assertEquals(valorEsperado,valorActual);
    }

}