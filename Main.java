/**
 *Tons k mami no la veo comentando o k
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Main
{   
    public static void main(String[] args)
    {
        HelioGame helioGame = new HelioGame();
        if(args[0].toLowerCase().equals("-gui")){
            helioGame.CorrerGUI();
        }
        else{
            helioGame.CorrerDOS();
        }        
    }
}
