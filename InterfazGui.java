
/**
 * Write a description of class InterfazGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.*;
import java.awt.*;
import javax.swing.*;


public class InterfazGui
{
    // instance variables - replace the example below with your own
    JFrame frame;
    JPanel carta1;
    JPanel carta2;
    JPanel carta3;
    InterfazGui(String titulo){
        frame= new JFrame(titulo);
        carta1= new JPanel();
        carta2= new JPanel();
        carta3= new JPanel();
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        carta1.setBackground(Color.BLACK);
        carta2.setBackground(Color.BLUE);
        carta3.setBackground(Color.RED);
        carta1.setSize(300,500);
        carta2.setSize(300,500);
        carta3.setSize(300,500);
        frame.add(carta1);
        carta1.setLocation(0,0);
        frame.add(carta2);
        carta2.setLocation(300,0);
        frame.add(carta3);
        carta3.setLocation(600,0);
    }
    /**public void mostrarMensaje(){
        String mensaje="a";
        String titulo="b";
       //JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(null,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }
    */
    public static void ejemplo(){
        new InterfazGui("HelioGames");
    
}
}
