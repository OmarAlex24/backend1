public class MenuVegetariano extends Menu {
    private int especias;
    private int salsasVegetarianas;

    public MenuVegetariano(double precioBase, int especias, int salsasVegetarianas) {
        super(precioBase);
        this.especias = especias;
        this.salsasVegetarianas = salsasVegetarianas;
    }

    public int getEspecias() {
        return especias;
    }

    public int getSalsasVegetarianas() {
        return salsasVegetarianas;
    }

    public void setEspecias(int especias) {
        this.especias = especias;
    }

    public void setSalsasVegetarianas(int salsasVegetarianas) {
        this.salsasVegetarianas = salsasVegetarianas;
    }
}
