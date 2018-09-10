
/**
 * Write a description of class HelioGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelioGame
{

    public void CorrerGUI()
    {
        
    }
    
    public void CorrerDOS()
    {
        Interfaz interfaz = new Interfaz();
        interfaz.imprimirMenu1();
        interfaz.pedirInt("Digite la opcion que desea: ");
    }
}
