
/**
 * Write a description of class InterfazGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InterfazGui
{
    // instance variables - replace the example below with your own
    JFrame frame;
    InterfazGui(){
        frame= new JFrame("pene jiji"); 
        frame.setSize(500,200);
        
        frame.setVisible(true);
    }
    /**public void mostrarMensaje(){
        String mensaje="a";
        String titulo="b";
       //JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }
    */
    public static void ejemplo(){
        new InterfazGui();
    
}
}
