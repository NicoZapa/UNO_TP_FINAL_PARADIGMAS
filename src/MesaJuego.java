import java.util.*;

public class MesaJuego {

    MazoUno mazo;
    List<Jugador> jugadores = new ArrayList<>();
    CartaUno cartaActiva;
    private final int CARTASxJUGADOR = 7;

    public MesaJuego(){
        //MAZO
        mazo = new MazoUno();

        //JUGADORES
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        jugadores.add(new Jugador("Jugador 3"));
        jugadores.add(new Jugador("Jugador 4"));

        //REPARTIMOS LAS CARTAS A CADA JUGADOR
        repartir();
    }

    private void repartir(){
        for(int i = 0; i < jugadores.size(); i++){ //CANTIDAD DE JUGADORES
            for(int j = 0; j < CARTASxJUGADOR; j++){ //CANTIDAD DE CARTAS x JUGADOR
               jugadores.get(i).setCartasMano(mazo.darCarta());
            }
        }
    }

    private void setCartaActiva(){

    }
}
