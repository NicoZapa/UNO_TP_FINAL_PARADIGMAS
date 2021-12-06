/*
* 0 al 9 => CARTAS COMUNES
* 10 11 12 => CARTAS ESPECIALES
* 13 14 => CARTAS NEGRAS
* */

// DEBEMOS LLENAR LA PILA DE DESCARTE PARA LUEGO PODER REUTILIZARLO COMO MAZO

import java.util.*;

public class MazoUno{

    ArrayList<CartaUno> mazo;
    private ArrayList<CartaUno> pilaDescarte = new ArrayList<>();
    private int posSiguienteCarta = 0;
    private CartaUno cartaDada;

    public MazoUno(){
        mazo = new ArrayList<>();
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
                        mazo.add(new CartaUno(colores[i], k));
                    }else if(j == 1){ //CREAMOS LAS CARTAS NEGRAS
                        mazo.add(new CartaUno(colores[4], k));
                    }
                }
            }
        }
        //mostrarMazo();
        mezclar(mazo);
    }

    //** MEZCLAMOS EL MAZO **
    private void mezclar(List<CartaUno> mazo){

        Collections.shuffle(mazo);
        Collections.shuffle(mazo);
        Collections.shuffle(mazo);

        //mostrarMazo();
    }

    //** AGREGAMOS CARTAS A LA PILA DE DESCARTE **
    public void setPilaDescarte(CartaUno carta){
        pilaDescarte.add(carta);
    }

    //** DAR CARTA AL JUGADOR **
    public CartaUno darCarta(){

        if(mazo.isEmpty()){
            System.out.println("EL MAZO ESTA VACIO. VAMOS A MEZCLAR LAS CARTAS YA JUGADAS");
            mezclar(pilaDescarte);
            pilaAMazo(pilaDescarte, mazo);
        }

        cartaDada = mazo.get(posSiguienteCarta);
        mazo.remove(posSiguienteCarta);
        return cartaDada;
    }

    //** LE DAMOS LAS CARTAS DE LA PILA AL MAZO **
    public void pilaAMazo(ArrayList<CartaUno> pila, ArrayList<CartaUno> mazo){
        for(int i = 0; i < pila.size(); i++){
            this.mazo.add(i, pila.get(i));
            pila.remove(pila.get(i));
        }
    }

    //** MOSTRAR EL MAZO **
    public void mostrarMazo(){
        int i = 1;

        for(CartaUno c : mazo){
            System.out.println(i + " " + c.toString());
            i++;
        }
    }
}
