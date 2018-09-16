import java.lang.Math;
import java.text.DecimalFormat;
import java.util.*;
public class Carta
{
    private double ataque;
    private double defensa;
    private String elemento;
    private String nombre;
    private List<String> listaElemento = new ArrayList<String>();
    private List<String> listaTierra = new ArrayList<String>();
    private List<String> listaFuego = new ArrayList<String>();
    private List<String> listaAgua = new ArrayList<String>();
    private DecimalFormat df = new DecimalFormat("#.0");
    public Carta(){
        
        
        ataque = Math.random()*11;
        defensa = Math.random()*11;
        if(ataque>10.0){
            ataque = (int) ataque;
        }      
        if(defensa>10.0){
            defensa = (int) defensa;
        }
        elemento=EscogerElemento();
        nombre=EscogerNombre(elemento);
        
        
       
    }
    
    public String EscogerElemento(){
        
        int index=(int)(Math.random()*3);
        listaElemento.add("Agua");
        listaElemento.add("Fuego");
        listaElemento.add("Tierra");
        
        return listaElemento.get(index);
    }
    public String EscogerNombre(String elemento){
        String nombre="";
        int index=(int)(Math.random()*3);
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
    public String getNombre()
    {
        return nombre;
    }
}
