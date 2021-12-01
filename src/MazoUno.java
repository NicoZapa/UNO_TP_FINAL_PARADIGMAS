/*
* 1 al 9 => CARTAS COMUNES
* 10 11 12 => CARTAS ESPECIALES
* 13 14 => CARTAS NEGRAS
* */

//1) METODO DAR CARTA
//2) SI NO HAY CARTAS => MEZCLAMOS LA PILA DE DESCARTE (PARA GENERAR EL MAZO) Y DAMOS CARTA
//3) CREAR UNA LISTA QUE TOME CARTAS Y QUE SEA LA PILA DE DESCARTE
//4) LA CARTA QUE SE JUEGA DEBE ESTAR EN UNA VARIABLE TIPO CARTAUNO

import UnoTest.Metodos;

import java.util.*;

public class MazoUno {

    ArrayList<CartaUno> cartas;
    ArrayList<CartaUno> pilaDescarte;
    //public static final int CARTAS_TOTALES = 104;
    int posSiguienteCarta = 0;

    public MazoUno(){
        cartas = new ArrayList<>();
        crearMazo();
    }

    public void crearMazo(){

        String[] colores = CartaUno.COLORES;

        //LLENAR LOS 4 COLORES
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


    public void mezclar(List<CartaUno> cartas){

        Collections.shuffle(cartas);
        Collections.shuffle(cartas);
        Collections.shuffle(cartas);

        System.out.println("\n** MAZO MEZCLADO **");
        mostrarMazo();
    }

    public CartaUno darCarta(){
        if(cartas.isEmpty()){
            System.out.println("EL MAZO ESTA VACIO. VAMOS A MEZCLAR LAS CARTAS YA JUGADAS");
            mezclar(pilaDescarte);
            return null;
        }else{
            return cartas.get(posSiguienteCarta++);
        }
    }

    public void mostrarMazo(){
        int i = 1;

        for(CartaUno c : cartas){
            System.out.println(i + " " + c.toString());
            i++;
        }
    }
}
