import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private Map<String, Computadora> computadoraMap;
    private static int contador = 0;

    public ComputadoraFactory() {
        computadoraMap = new HashMap<>();
    }

    public static int getContador() {
        return contador;
    }

    public Computadora getComputadora(int ram, int discoDuro){

        String key = "PC"+ram+discoDuro;


        if(!computadoraMap.containsKey(key)){
            Computadora nuevaComputadora = new Computadora(ram, discoDuro);
            computadoraMap.put(key,nuevaComputadora);
            System.out.println("Computadora creada con exito");

            return nuevaComputadora;
        }

        contador++;
        return computadoraMap.get(key);
    }
}
