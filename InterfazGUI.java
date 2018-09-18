
<<<<<<< HEAD
//Clase en la que se construye la interfaz gráfica. 
import javax.swing.JOptionPane;
=======
>>>>>>> 3ac4138b95b95f706a55a3b830ba89fce350de11
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;
public class InterfazGUI{
    private DecimalFormat df; 
    String[] opciones={"1","2","3"};
    String SALIR= "Esta seguro que desea abandonar la partida?\n \n";
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
            cambioAtaqueAux=JOptionPane.showInputDialog(null,PORCENCENTAJE_DE_ATAQUE, TITULO, JOptionPane.PLAIN_MESSAGE);
            if(cambioAtaqueAux==null){
                valido=true;
            }else{
                if(!cambioAtaqueAux.matches("^[0-9]+$")){
                    valido=false; 
                    JOptionPane.showMessageDialog(null,ERROR_ATAQUE, TITULO,JOptionPane.WARNING_MESSAGE);
                }else{
                    if(Integer.parseInt(cambioAtaqueAux)<=100 && Integer.parseInt(cambioAtaqueAux)>=0){
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

    public String opcionesCartas(Carta carta1,Carta carta2, Carta carta3)
    {
        mostrarCartas(carta1);
        mostrarCartas(carta2);
        mostrarCartas(carta3);
        boolean salir=false;
        String opc;
        do{
         opc = (String)JOptionPane.showInputDialog(null,
               "1)"+ carta1.getNombre()+"->  Ataque: "+carta1.getAtaque()+"| Defensa: " +carta1.getDefensa()+"| Elemento: " +carta1.getElemento()+"\n\n"+
               "2)"+carta2.getNombre()+"->  Ataque: "+carta2.getAtaque()+"| Defensa: " +carta2.getDefensa()+"| Elemento: " +carta2.getElemento()+"\n\n"+
               "3)"+carta3.getNombre()+"->  Ataque: "+carta3.getAtaque()+"| Defensa: " +carta3.getDefensa()+"| Elemento: " +carta3.getElemento()+"\n\n"
            , TITULO, JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]);
         if(opc==null){
             if(JOptionPane.showConfirmDialog (null, SALIR,"Salir?", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ 
                opc="s";
                salir=true;
                }   
            }else{
                salir=true;
            }
        }while(salir==false);
        return opc;
    }

    public void mostrarCartas(Carta carta){

        String rutaIcono="images/"+carta.getNombre()+".png";
        ImageIcon icon = new ImageIcon(rutaIcono);
        JOptionPane.showMessageDialog(null,
            " ~ "+carta.getNombre()+" ~\n"+
            "Ataque----"+carta.getAtaque()+"\n"+

            "Defensa---"+carta.getDefensa()+"\n"+

            "Elemento--"+carta.getElemento()+"\n",
            TITULO, JOptionPane.QUESTION_MESSAGE,icon);

    }
    public void luchaDeCartas(Carta carta1,Carta carta2, String jugador){ //Hacer que se vea cool
        JOptionPane.showMessageDialog(null,
               jugador+":\n\n"+ carta1.getNombre()+"->  Ataque: "+carta1.getAtaque()+"| Defensa: " +carta1.getDefensa()+"| Elemento: " +carta1.getElemento()+"\n\n"+
               "VS\n\n"+
               "Computadora:\n\n"+carta2.getNombre()+"->  Ataque: "+carta2.getAtaque()+"| Defensa: " +carta2.getDefensa()+"| Elemento: " +carta2.getElemento()+"\n\n",
               TITULO, JOptionPane.PLAIN_MESSAGE);
    }
    public void resultadoRonda(String score, int rondasRestantes)
    {
        try
        {
            JOptionPane.showMessageDialog(null,
                "Su puntaje despues de este enfrentamiento es: "+score+"\n",
            TITULO, JOptionPane.PLAIN_MESSAGE);
       if(rondasRestantes==1){
           JOptionPane.showMessageDialog(null,
                "\n                   ** Ronda Final! **",
            TITULO, JOptionPane.PLAIN_MESSAGE);
            }
            else
                if(rondasRestantes==0){
                     JOptionPane.showMessageDialog(null,
                    "\n               ~~~ Gracias por jugar! ~~~\n",
                    TITULO, JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                    "\n                   Faltan "+rondasRestantes+" rondas!",
                    TITULO, JOptionPane.PLAIN_MESSAGE);
                }

        }
        catch(Exception e){
        }   
    }
          public void cambioMarcador()
    {
        try
        {

             JOptionPane.showMessageDialog(null,
             "\n     -- Felicidades, entraste al salon de la fama! --\n",
                    TITULO, JOptionPane.PLAIN_MESSAGE);

        }
        catch(Exception e){
        }
    }
    

   

}
