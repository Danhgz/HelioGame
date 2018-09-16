/**
 *Tons k mami no la veo comentando o k
 * 
 * @author (Daniel Henao B83714, Sergio Martinez B84621, Paula PoWoOn B86080) 
 * @version (1.0)
 */

public class Main
{   
    public static void main(String[] args)
    {
        
        if(args.length > 0 && args[0].toLowerCase().equals("-gui"))
        {
            HelioGame helioGame = new HelioGame('g');
            helioGame.correrGUI();
        }
        else
        {
            HelioGame helioGame = new HelioGame('d');
            helioGame.correrDOS();
        }        
    }
}
