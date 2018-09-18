//Clase en la que se construye la interfaz gráfica. 
import javax.swing.JOptionPane;
import java.util.*;
import java.text.DecimalFormat;
public class InterfazGUI{
    private DecimalFormat df; 
    String[] opciones={"1","2","3"};
    String CAMBIAR_NOMBRE="~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                         " -Cual es el nombre de la proxima leyenda?\n ";
                         
    String ERROR_RONDAS="Error! Digite un numero entero positivo\n";
    
    String ERROR_ATAQUE="Error! Digite un numero entre 0-100\n";
    
    String RONDAS="\nDigite la cantidad de rondas por partida: \n\n";
    
    String PORCENCENTAJE_DE_ATAQUE="\nDigite el % de modificacion de ataque: \n\n";
    
    String TITULO="Helio Games";
    
    String MENU_PRINCIPAL=           "~~~~~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
        " 1. Indicar cantidad de enfrentamientos por juego       \n"+
        " 2. Indicar porcentaje de modificacion de peso de ataque\n"+
        " 3. Iniciar un juego nuevo                              \n\n";
        
    String MENU_JUEGO="~~~~~~~~~~~~~~~~~~~~NUEVO JUEGO~~~~~~~~~~~~~~~~~~~~~~~\n\n"+                        
        " 1. Ver usuario y puntaje maximo                        \n"+
        " 2. Cambiar nombre del jugador                          \n"+
        " 3. Iniciar partida                                     \n\n";
        
    public InterfazGUI()
    {
        
        df = new DecimalFormat("0.00");
    }

    public String imprimirMenuPrincipal(){
        String opc = (String)JOptionPane.showInputDialog(null, MENU_PRINCIPAL, TITULO, JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]);
        if(opc==null){
            opc="Salir";
        }

        return opc;
    }

    public int modificarCambioAtaque(int cambioAtaque)
    {
        String  cambioAtaqueAux;
        boolean valido= false;
        do{
            cambioAtaqueAux=JOptionPane.showInputDialog(null,RONDAS, TITULO, JOptionPane.PLAIN_MESSAGE);
            if(cambioAtaqueAux==null){
                valido=true;
            }else{
                if(!cambioAtaqueAux.matches("^[0-9]+$")){
                    valido=false; 
                    JOptionPane.showMessageDialog(null,ERROR_ATAQUE, TITULO,JOptionPane.WARNING_MESSAGE);
                }else{
                    if(!(Integer.parseInt(cambioAtaqueAux)<=100 && Integer.parseInt(cambioAtaqueAux)>=0)){
                        valido=true; 
                        cambioAtaque=Integer.parseInt(cambioAtaqueAux);
                    }
                }
            }
        }while(valido==false);
        return cambioAtaque;
    }
    // Integer.parseInt(JOptionPane.showInputDialog(null,RONDAS, TITULO, JOptionPane.PLAIN_MESSAGE));
    public int modificarRondas(int rondas)
    {
        String rondaAux; 
        boolean valido= false;
        do{
            rondaAux=JOptionPane.showInputDialog(null,RONDAS, TITULO, JOptionPane.PLAIN_MESSAGE);
            if( rondaAux==null){
                valido= true;
            }else{
                if(!rondaAux.matches("^[0-9]+$")&& !rondaAux.matches("^0+$")){
                    JOptionPane.showMessageDialog(null, ERROR_RONDAS, TITULO,JOptionPane.WARNING_MESSAGE);
                }else{
                    valido= true;
                    rondas=Integer.parseInt(rondaAux);
                }
            }
        }while(valido==false);
        return rondas;
    }

    public String imprimirMenuJuego()
    {

        String opc = (String)JOptionPane.showInputDialog(null, MENU_JUEGO, TITULO, JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]);
        if(opc==null){
            opc="Salir";
        }

        return opc;
    }

    public void verMarcadores(double[] highscore, String[] highscorer){
        JOptionPane.showMessageDialog(null,
                             "~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~\n"+        
                             "-*-*-*-*-*-*-*- Salon de la Fama -*-*-*-*-*-*-*-\n\n"+
                             "     1- "+df.format(highscore[0])+"        "+highscorer[0]+"\n"+
                             "     2- "+df.format(highscore[1])+"        "+highscorer[1]+"\n"+
                             "     3- "+df.format(highscore[2])+"        "+highscorer[2]+"\n"
                             , TITULO,JOptionPane.PLAIN_MESSAGE);
    }
    
    public String cambiarNombre(String jugador)
    {
        
        String jugAux = (String)JOptionPane.showInputDialog(null, CAMBIAR_NOMBRE, TITULO, JOptionPane.PLAIN_MESSAGE);
        if(!(jugAux==null)){
            jugador=jugAux;
        }

        return jugador;
    }
}
