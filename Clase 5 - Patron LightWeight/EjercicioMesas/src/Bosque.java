import java.util.ArrayList;
import java.util.List;

public class Bosque {
    public static void main(String[] args) {
        ArbolFactory fabricaArboles = new ArbolFactory();
        List<Arbol> listaArboles = new ArrayList<>();

        for (int i = 0; i < 500000; i++){
            listaArboles.add(fabricaArboles.getArbol("Ornamental"));
            listaArboles.add(fabricaArboles.getArbol("Frutales"));
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada:"  + (runtime.totalMemory() -
                runtime.freeMemory()) / (1024 * 1024) + "MB");

    }
}
