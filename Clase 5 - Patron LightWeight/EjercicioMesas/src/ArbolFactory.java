import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private Map<String,Arbol> arbolesMap;
    private static int contadorArboles = 0;

    public ArbolFactory(){
        arbolesMap = new HashMap<>();
    }

    public Arbol getArbol(String tipoArbol){
        String key ="arbol" + tipoArbol.toLowerCase();

        if(!arbolesMap.containsKey(key)){
            switch (tipoArbol.toLowerCase()){
                case "ornamental":
                    arbolesMap.put(key, new ArbolOrnamental());
                    System.out.println("Arbol creado con exito");
                    break;
                case "frutal":
                    arbolesMap.put(key, new ArbolFrutal());
                    System.out.println("Arbol creado con exito");
                    break;
                case "floral":
                    arbolesMap.put(key, new ArbolFloral());
                    System.out.println("Arbol creado con exito");
                    break;
                default:
                    System.out.println("Ingreso un tipo de arbol desconocido");
            }
        }
        System.out.println("Arboles plantados: " + ++contadorArboles);
        return arbolesMap.get(key);
    }
}
