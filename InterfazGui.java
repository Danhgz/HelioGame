
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
    JPanel carta4;
    
    JLabel imagen1;
    InterfazGui(String titulo){
        frame= new JFrame(titulo);
        carta1= new JPanel();
        carta2= new JPanel();
        carta3= new JPanel();
        carta4= new JPanel();
        
        frame.setSize(905,530);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        //carta1.setBackground(Color.BLACK);
        //carta2.setBackground(Color.BLUE);
        //carta3.setBackground(Color.RED);
        
       
        
        crearPanel(2.0,2.0,"Mudkip","Agua",carta1,frame);
        crearPanel(2.0,2.0,"Squirtle","Agua",carta2,frame);
        crearPanel(2.0,2.0,"Totodile","Agua",carta3,frame);
        crearPanel(0.0,0.0,null,null,carta4,frame);
        carta1.setLocation(0,0);
       carta2.setLocation(300,0);
       carta3.setLocation(600,0);
      carta4.setVisible(false);
        
     
        
        
    }
    public static void crearPanel(double ataque,double defensa,String nombre,String Simbolo, JPanel carta,JFrame frame){
        JLabel imagen = new JLabel();
       
        String ruta ="images\\"+nombre+".png";
        if (Simbolo=="Fuego"){
           carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(204, 82, 0)));
           carta.setBackground(new Color(255, 163, 102));//rojo
        }
        if (Simbolo=="Agua"){
            carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(0, 102, 204)));
            carta.setBackground(new Color(128, 191, 255));//celeste
        }
            if (Simbolo=="Tierra"){
            carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(102, 153, 0)));
            carta.setBackground(new Color(153, 230, 0));//verde
        }
        
        imagen.setIcon(new ImageIcon(ruta));
        carta.add(imagen);
        carta.setSize(300,500); 
        frame.add(carta);
        carta.setVisible(true);
    }
    public static void ejemplo(){
        new InterfazGui("HelioGames");
    
}
}
