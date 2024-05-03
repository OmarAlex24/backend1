package mesa;

public class Cuadrado {

    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public boolean valorValido(){
        return lado > 0;
    }

    public boolean sonNumeros(){
        return Character.isDigit(lado);
    }

    public float calcularArea(){
        if(!valorValido() || !sonNumeros()){
            System.out.println("No se pudo calcular el area");
            return -1;
        }

        float areaCuadrado = (float) Math.pow(lado,2);

        System.out.println("El área del cuadrado es "+ (areaCuadrado) +" unidades");
        return areaCuadrado;
    }
}
