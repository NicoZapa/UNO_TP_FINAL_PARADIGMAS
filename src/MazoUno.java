/*
* 0 al 9 => CARTAS COMUNES
* 10 11 12 => CARTAS ESPECIALES
* 13 14 => CARTAS NEGRAS
* */

// DEBEMOS LLENAR LA PILA DE DESCARTE PARA LUEGO PODER REUTILIZARLO COMO MAZO

import java.util.*;

public class MazoUno{

    ArrayList<CartaUno> cartas;
    private ArrayList<CartaUno> pilaDescarte = new ArrayList<>();
    private int posSiguienteCarta = 0;
    private CartaUno cartaDada;

    public MazoUno(){
        cartas = new ArrayList<>();
        crearMazo();
    }

    //** CREAMOS EL MAZO **
    private void crearMazo(){

        String[] colores = CartaUno.COLORES;

        //LLENAR LOS 5 COLORES
        for(int i = 0; i < colores.length-1; i++) { //CREAMOS CARTAS COLOR MENOS EL NEGRO
            for(int j = 0; j < 2; j++){ //CARTAS REPETIDAS x COLOR
                for (int k = 0; k <= CartaUno.CARTASxCOLOR/2; k++) { //CARTAS x COLOR
                    if(k <= 12){
                        cartas.add(new CartaUno(colores[i], k));
                    }else if(j == 1){ //CREAMOS LAS CARTAS NEGRAS
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

    //** AGREGAMOS CARTAS A LA PILA DE DESCARTE **
    private void setPilaDescarte(CartaUno carta){
        pilaDescarte.add(carta);
    }

    //** DAR CARTA AL JUGADOR **
    public CartaUno darCarta(){

        if(cartas.isEmpty()){
            System.out.println("EL MAZO ESTA VACIO. VAMOS A MEZCLAR LAS CARTAS YA JUGADAS");
            mezclar(pilaDescarte);
            pilaAMazo(pilaDescarte, cartas);
        }

        cartaDada = cartas.get(posSiguienteCarta);
        cartas.remove(posSiguienteCarta);
        return cartaDada;
    }

    //** LE DAMOS LAS CARTAS DE LA PILA AL MAZO **
    public void pilaAMazo(ArrayList<CartaUno> pila, ArrayList<CartaUno> mazo){
        for(int i = 0; i < pila.size(); i++){
            cartas.add(i, pila.get(i));
            pila.remove(pila.get(i));
        }
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
