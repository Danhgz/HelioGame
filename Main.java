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
        if(args[0].toLowerCase().equals("-gui")){
            InterfazGui interfaz1 = new InterfazGui();
            interfaz1.mainMenu();
        }
        else{
            Interfaz interfaz1 = new Interfaz();
            interfaz1.mainMenu();
        }        
    }
}
