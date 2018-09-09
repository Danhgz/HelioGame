/**
 * Write a description of class Cartas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
import java.text.DecimalFormat;
public class Cartas
{
    private double ataque;
    private double defensa;
    private String elemento;
    private DecimalFormat df = new DecimalFormat("#.0");
    public Cartas()
    {
        ataque = Math.random()*11;
        defensa = Math.random()*11;
        if(ataque>10.0){
            ataque = (int) ataque;
        }      
        if(defensa>10.0){
            defensa = (int) defensa;
        }
        
        switch((int)Math.random()*3)
        {
            case 0:
            elemento = "Agua";
            break;
        
            case 1:
            elemento = "Fuego";
            break;  
        
            default:
            elemento = "Tierra";
        }
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
