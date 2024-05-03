package mesa;

public class Circulo {

    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public boolean valorValido(){
        return this.radio > 0;
    }

    public boolean sonNumeros(){
        return Character.isDigit(radio);
    }

    public float calcularArea(){
        if(!valorValido()){
            System.out.println("No se pudo calcular el area");
            return -1;
        }

        float areaCiculo = (float) (Math.PI*Math.pow(radio,2));
        System.out.println("El área del cuadrado es "+ (areaCiculo) +" unidades");
        return areaCiculo;
    }
}
