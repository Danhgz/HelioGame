import java.lang.*;
import java.awt.*;
import javax.swing.*;

public class InterfazGUI
{
    // instance variables - replace the example below with your own
    JFrame frame;
    JPanel carta1;
    JPanel carta2;
    JPanel carta3;
    JPanel carta4;
    
    JLabel imagen1;
    public InterfazGUI(String titulo){
        frame= new JFrame(titulo);
        carta1= new JPanel();
        carta2= new JPanel();
        carta3= new JPanel();
        carta4= new JPanel();
        
        frame.setSize(905,535);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        //carta1.setBackground(Color.BLACK);
        //carta2.setBackground(Color.BLUE);
        //carta3.setBackground(Color.RED);
        
       
        
        crearPanel(2.0,2.0,"Mudkip","Agua",carta1,frame);
        crearPanel(2.0,2.0,"Trecko","Tierra",carta2,frame);
        crearPanel(2.0,2.0,"Torchic","Agua",carta3,frame);
        crearPanel(0.0,0.0,null,null,carta4,frame);
        carta1.setLocation(0,0);
       carta2.setLocation(300,0);
       carta3.setLocation(600,0);
      carta4.setVisible(false);
        
     
        
        
    }
    public static void crearPanel(double ataque,double defensa,String nombre,String simbolo, JPanel carta,JFrame frame){
        JLabel imagen = new JLabel();
        JLabel nomb=new JLabel(nombre);
        JLabel atq=new JLabel("Ataque: "+ataque);
        JLabel dfns=new JLabel("Defensa: "+defensa);
        JButton boton=new JButton();
        String ruta ="images\\"+nombre+".png";
        String rutaboton ="images\\"+simbolo+".png";
        if (simbolo=="Fuego"){
           carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(204, 82, 0)));
           carta.setBackground(new Color(255, 163, 102));//rojo
        }
        if (simbolo=="Agua"){
            carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(0, 102, 204)));
            carta.setBackground(new Color(128, 191, 255));//celeste
        }
            if (simbolo=="Tierra"){
            carta.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,new Color(102, 153, 0)));
            carta.setBackground(new Color(153, 230, 0));//verde
        }
        nomb.setFont(new Font("Arial", Font.BOLD, 40));
        nomb.setForeground(Color.WHITE);
        atq.setFont(new Font("Arial", Font.BOLD, 30));
        atq.setForeground(Color.WHITE);
        dfns.setFont(new Font("Arial", Font.BOLD, 30));
        dfns.setForeground(Color.WHITE);
        imagen.setIcon(new ImageIcon(ruta));
        boton.setIcon(new ImageIcon(rutaboton));
        boton.setBorderPainted(false);
boton.setBorder(null);
//button.setFocusable(false);
boton.setMargin(new Insets(0, 0, 0, 0));
boton.setContentAreaFilled(false);
        carta.add(imagen);
        carta.add(nomb);
        carta.add(atq);
        carta.add(dfns);
        carta.add(boton);
        carta.setSize(300,500); 
        frame.add(carta);
        carta.setVisible(true);
    }
    public static void ejemplo(){
        new InterfazGUI("HelioGames");
    
}
}
