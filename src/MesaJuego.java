import java.util.*;

public class MesaJuego extends ReglasUno{

    MazoUno mazo;
    List<Jugador> jugadores = new ArrayList<>();
    private CartaUno cartaActiva;
    private final int CARTASxJUGADOR = 7;
    boolean juegoFuncionando = true;
    Scanner in = new Scanner(System.in);
    int elijoCarta;

    public MesaJuego(){

        //MAZO
        mazo = new MazoUno();

        //JUGADORES
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        //jugadores.add(new Jugador("Jugador 3"));
        //jugadores.add(new Jugador("Jugador 4"));

        //REPARTIMOS LAS CARTAS A CADA JUGADOR
        repartir();
        cartaActiva = mazo.darCarta();
        //MostrarCartaActiva();
        playGame();
    }

    private void repartir(){
        for(int i = 0; i < jugadores.size(); i++){ //CANTIDAD DE JUGADORES
            for(int j = 0; j < CARTASxJUGADOR; j++){ //CANTIDAD DE CARTAS x JUGADOR
               jugadores.get(i).setCartasMano(mazo.darCarta());
            }
            //jugadores.get(i).mostrarMano();
        }
        //mazo.mostrarMazo();
    }

    public void setCartaActiva(CartaUno carta){
        mazo.setPilaDescarte(carta);
    }

    public void MostrarCartaActiva() {
        System.out.println("\nCARTA ACTIVA \n" + cartaActiva);
    }

    //****************
    public void playGame(){

        while(juegoFuncionando){

            int turno = 0;

            while(turno == 0){
                System.out.println("-----------------------------------");
                System.out.println("¿QUE CARTA VA A JUGAR?");
                jugadores.get(turno).mostrarMano();
                MostrarCartaActiva();
                System.out.println("-----------------------------------");
                System.out.print("\nELECCION: ");
                elijoCarta = in.nextInt();

                turno++;
            }

            while(turno == 1){
                System.out.println("-----------------------------------");
                System.out.println("----¿QUE CARTA VA A JUGAR?----");
                jugadores.get(turno).mostrarMano();
                MostrarCartaActiva();
                System.out.println("-----------------------------------");
                System.out.print("\nELECCION: ");
                elijoCarta = in.nextInt();
                turno++;
            }
        }
    }
}
