/**
 * 
 * @author (Daniel Henao B83714, Sergio Martinez B84621, Paula PoWoOn B86080) 
 */

public class Main
{   
    public static void main(String[] args)
    {
        //corre el juego con la interfaz grafica. 
        if(args.length > 0 && args[0].toLowerCase().equals("-gui"))
        {
            HelioGame helioGame = new HelioGame('g');
            helioGame.correrGUI();
        }
        else //corre el juego con la interfaz de texto. 
        {
            HelioGame helioGame = new HelioGame('d');
            helioGame.correrDOS();
        }        
    }
}
