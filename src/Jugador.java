import java.util.ArrayList;
import java.util.List;

public class Jugador{
    private String nombre;
    private List<CartaUno> cartasMano;

    public Jugador(String nombre){
        this.nombre = nombre;
        cartasMano = new ArrayList<>();
    }

    //** AGREGAMOS CARTA A LA MANO DEL JUGADOR **
    public void setCartasMano(CartaUno carta) {
        this.cartasMano.add(carta);
    }

}
