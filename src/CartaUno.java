public class CartaUno{
    private String color;
    private int numero;

    public static final String[] COLORES = {"ROJO", "AMARILLO", "AZUL", "VERDE", "NEGRO"};
    public static final int CARTASxCOLOR = 28;
    public static final int CARTASNEGRAS = 8;

    public CartaUno(String color, int numero){
        this.color = color;
        this.numero = numero;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "CartaUno{" +
                "color='" + color + '\'' +
                ", numero=" + numero +
                '}';
    }
}
