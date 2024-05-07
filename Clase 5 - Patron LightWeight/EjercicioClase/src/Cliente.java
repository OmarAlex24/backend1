public class Cliente {
    public static void main(String[] args) {
        ComputadoraFactory fabricaPc = new ComputadoraFactory();

        Computadora pc1 = fabricaPc.getComputadora(2,128);
        Computadora pc2 = fabricaPc.getComputadora(2,128);
        Computadora pc3 = fabricaPc.getComputadora(2,128);
        Computadora pc4 = fabricaPc.getComputadora(16,128);
        Computadora pc5 = fabricaPc.getComputadora(8,128);
        Computadora pc6 = fabricaPc.getComputadora(2,256);

        System.out.println("Computadoras creadas: "+ Computadora.getContador());
        System.out.println("Computadoras reutilizadas: " + ComputadoraFactory.getContador());
    }
}
