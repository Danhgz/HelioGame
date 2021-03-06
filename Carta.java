 //Clase para definir las caracteristicas de las cartas del juego. 
import java.lang.Math;
import java.text.DecimalFormat;
public class Carta
{
    private double ataque;
    private double defensa;
    private String elemento;
    private String nombre;
    private String[] listaElemento;
    private String[] listaAgua;
    private String[] listaFuego;
    private String[] listaTierra;
    private DecimalFormat df;
    
    public Carta(){ //asigna las caracteristicas de las cartas.
        //asigna el ataque y la defensa aleatoriamente.
        df = new DecimalFormat("0.0");
        ataque = Math.random()*10.1;
        defensa = Math.random()*10.1;
        //casting del ataque y defensa para convertirlos a numeros enteros. 
        if(ataque>10.0){
            ataque = (int) ataque;
        }      
        if(defensa>10.0){
            defensa = (int) defensa;
        }
        // asigna los nombres con su respectivo elemento. 
        listaElemento = new String[]{"Agua","Fuego","Tierra"};
        listaAgua = new String[]{"Squirtle","Totodile","Mudkip"};
        listaFuego= new String[]{"Charmander","Cyndaquil","Torchic"};
        listaTierra = new String[]{"Bulbasaur","Chikorita","Trecko"};                
        elemento=escogerElemento();
        nombre= escogerNombre(elemento);       
    }

    public String escogerElemento(){ //Método que escoge el elemento de la carta. 
     //método para asignarle un elemento a las cartas.
        int index=(int)(Math.random()*3);       
        return listaElemento[index];
    }
    
    public String escogerNombre(String elemento) 
    // Método que escoge el nombre de la carta basado en su elemento
    {
        String nombre="";
        int index=(int)(Math.random()*3);
        if (elemento=="Tierra"){
            nombre=listaTierra[index];
        }
        if (elemento=="Fuego"){
            nombre=listaFuego[index];
        }
        if (elemento=="Agua"){
        nombre=listaAgua[index];
        }
        return nombre;
    }
       
    public String getNombre()
    {
        return nombre;
    }
    public String getAtaque()
    {
        return df.format(ataque);
    }    
    public String getDefensa()
    {
        return df.format(defensa);
    }    
    public String getElemento()
    {
        return elemento;
    }    
}
