/*
* 0 al 9 => CARTAS COMUNES
* 10 11 12 => CARTAS ESPECIALES
* 13 14 => CARTAS NEGRAS
* */

//1) METODO DAR CARTA
//2) SI NO HAY CARTAS => MEZCLAMOS LA PILA DE DESCARTE (PARA GENERAR EL MAZO) Y DAMOS CARTA
//3) CREAR UNA LISTA QUE TOME CARTAS Y QUE SEA LA PILA DE DESCARTE
//4) LA CARTA QUE SE JUEGA DEBE ESTAR EN UNA VARIABLE TIPO CARTAUNO

import java.util.*;

public class MazoUno {

    private List<CartaUno> cartas;
    private List<CartaUno> pilaDescarte = new ArrayList<>();
    private int posSiguienteCarta = 0;

    public MazoUno(){
        cartas = new ArrayList<>();
        crearMazo();
    }

    //** CREAMOS EL MAZO **
    private void crearMazo(){

        String[] colores = CartaUno.COLORES;

        //LLENAR LOS 5 COLORES
        for(int i = 0; i < colores.length-1; i++) { //LOS COLORES
            for(int j = 0; j < 2; j++){ //CARTAS REPETIDAS x COLOR
                for (int k = 0; k <= CartaUno.CARTASxCOLOR/2; k++) { //CARTAS x COLOR
                    if(k <= 12){
                        cartas.add(new CartaUno(colores[i], k));
                    }else if(j == 1){
                        cartas.add(new CartaUno(colores[4], k));
                    }
                }
            }
        }
        mostrarMazo();
        mezclar(cartas);
    }

    //** MEZCLAMOS EL MAZO **
    private void mezclar(List<CartaUno> cartas){

        Collections.shuffle(cartas);
        Collections.shuffle(cartas);
        Collections.shuffle(cartas);

        System.out.println("\n** MAZO MEZCLADO **");
        mostrarMazo();
    }

    //** AGREGAMOS A LA PILA DE DESCARTE **
    private void setPilaDescarte(CartaUno carta){
        pilaDescarte.add(carta);
    }

    //** DAR CARTA AL JUGADOR **
    public CartaUno darCarta(){
        if(cartas.isEmpty()){
            System.out.println("EL MAZO ESTA VACIO. VAMOS A MEZCLAR LAS CARTAS YA JUGADAS");
            mezclar(pilaDescarte);
            posSiguienteCarta = 0;
        }
        return cartas.get(posSiguienteCarta++);
    }

    //** MOSTRAR EL MAZO **
    public void mostrarMazo(){
        int i = 1;

        for(CartaUno c : cartas){
            System.out.println(i + " " + c.toString());
            i++;
        }
    }
}
