package presencial;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> listaPersonas;

    public Grupo() {
        listaPersonas = new ArrayList<>();
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void agregarPersona(Persona nuevaPersona){
        if(nuevaPersona.esPersonaValida()){
            listaPersonas.add(nuevaPersona);
        }
    }
}
