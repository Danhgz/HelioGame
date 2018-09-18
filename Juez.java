// Calcula el puntaje que gana el jugador al comparar su carta contra la de la computadora. 

public class Juez
{
    private double signo; //ayuda a determinar si el jugador lleva la ventaja 
    private double ataque;
    private double defensa;
    public double comparar(Carta atacante, Carta defensor,int cambioAtaque)
    {
        ataque = Double.parseDouble(atacante.getAtaque());
        defensa= Double.parseDouble(defensor.getDefensa());
        switch(atacante.getElemento()) //establece las comparaciones de poder entre los elementos 
        {
            case "Agua":
                if(defensor.getElemento().equals("Fuego")){
                    signo= 1.0;
                }
                else{
                    if(defensor.getElemento().equals("Agua")){
                        signo= 0.0;
                    }
                    else{
                        signo= -1.0;
                    } 
                }
                break;
                
            case "Fuego":
                if(defensor.getElemento().equals("Tierra")){
                    signo= 1.0;
                }
                else{
                    if(defensor.getElemento().equals("Fuego")){
                        signo= 0.0;
                    }
                    else{
                        signo= -1.0;
                    }
                }
                break;
                
            case "Tierra":
                if(defensor.getElemento().equals("Agua")){
                    signo= 1.0;
                }
                else{
                    if(defensor.getElemento().equals("Tierra")){
                        signo= 0.0;
                    }
                    else{
                        signo= -1.0;
                    }
                }
                break;     
        }               
        return (ataque+signo*ataque*cambioAtaque/100)-defensa;
        //formula para determinar la fuerza de ataque de un atacante contra su oponente
    }
}
