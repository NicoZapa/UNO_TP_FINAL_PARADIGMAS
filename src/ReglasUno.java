import java.util.ArrayList;

public class ReglasUno {

    public static boolean isCarta0al9(CartaUno carta, CartaUno cartaActiva){
        if(carta.getNumero() <= 9){
            if(cartaActiva.getNumero() == carta.getNumero() || cartaActiva.getColor().equals(carta.getColor())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean isMasDos(CartaUno carta, CartaUno cartaActiva){
        if(carta.getNumero() == 10){
            if(cartaActiva.getColor().equals(carta.getColor())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean isMismoColor(CartaUno carta, CartaUno cartaActiva){
        if(cartaActiva.getColor().equals(carta.getColor())){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isMismoNumero(CartaUno carta, CartaUno cartaActiva){
        if(cartaActiva.getNumero() == carta.getNumero()){
            return true;
        }else{
            return false;
        }
    }
    
}
