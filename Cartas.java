import java.lang.Math;
import java.text.DecimalFormat;
import java.util.*;
public class Cartas
{
    private double ataque;
    private double defensa;
    private String elemento;
    private String nombre;
    private String[] arrayElemento;
    private List<String> listaTierra = new ArrayList<String>();
    private List<String> listaFuego = new ArrayList<String>();
    private List<String> listaAgua = new ArrayList<String>();
    private DecimalFormat df = new DecimalFormat("#.0");
    
    public Cartas(){        
        ataque = Math.random()*10.1; //Modifica ligeramente la media a costo obtener numeros decimales y el 10.0
        defensa = Math.random()*10.1;
        if(ataque>10.0){
            ataque = (int) ataque;
        }      
        if(defensa>10.0){
            defensa = (int) defensa;
        }
        arrayElemento = new String[]{"Agua","Fuego","Tierra"};
        elemento=escogerElemento();
        nombre=escogerNombre(elemento);                       
    }
    
    public String escogerElemento(){                        
        int index=(int)Math.random()*3;
        return arrayElemento[index];
    }
    public String escogerNombre(String elemento){
        String nombre="";
        int index=(int)Math.random()*3;
        if (elemento=="Tierra"){
            listaTierra.add("Bulbasaur");
            listaTierra.add("Chikorita");
            listaTierra.add("Trecko");
            nombre=listaTierra.get(index);
        }
        if (elemento=="Fuego"){
            listaFuego.add("Charmander");
            listaFuego.add("Cyndaquil");
            listaFuego.add("Torchic");
            nombre=listaFuego.get(index);
        }
        if (elemento=="Agua"){
        listaAgua.add("Squirtle");
        listaAgua.add("Totodile");
        listaAgua.add("Mudkip");
        nombre=listaAgua.get(index);
        }
        return nombre;
    }
       
    public String getNombre(){
        return nombre;
    }
    public String getAtaque(){
        return df.format(ataque);
    }    
    public String getDefensa(){
        return df.format(defensa);
    }   
    public String getElemento(){
        return elemento;
    }
    
}
