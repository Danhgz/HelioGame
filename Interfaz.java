import java.util.Scanner; 
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;

public class Interfaz 
{
    private Scanner input;
    private DecimalFormat df; 
    public Interfaz()
    {
        input = new Scanner (System.in);
        df = new DecimalFormat("#.00");
    }

    public String imprimirMenuPrincipal(boolean err)
    {
        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                         " 1. Indicar cantidad de enfrentamientos por juego       \n"+
                         " 2. Indicar porcentaje de modificacion de peso de ataque\n"+
                         " 3. Iniciar un juego nuevo                              \n"+
                         " 4. Salir                                               \n\n");

        if(err){
            System.out.print("  -Error! Digite una una opcion valida: ");
        }       
        else{
            System.out.print("  -Digite la opcion que desea: ");
        }
        return input.next();                       
    }

    public String imprimirMenuJuego(boolean err)
    {
        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~~~~~~~~~NUEVO JUEGO~~~~~~~~~~~~~~~~~~~~~~~\n\n"+                        
            " 1. Ver usuario y puntaje maximo                        \n"+
            " 2. Cambiar nombre del jugador                          \n"+
            " 3. Iniciar partida                                     \n"+
            " 4. Regresar                                            \n\n");
        if(err){
            System.out.print("  -Error! Digite una una opcion valida: ");
        }       
        else{
            System.out.print("  -Digite la opcion que desea: ");
        }
        return input.next();
    }

    public int modificarRondas()
    {
        int rondas = 0;    
        boolean err= false;
        boolean modificado=false;
        String rondasAux;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            if(err){
                System.out.print(" Error! Digite un numero entero positivo o \"S\" para salir\n\n");
            }
            else{
                System.out.print(" (Digite S para salir)\n\n");
            }
            System.out.print(" -Digite la cantidad de rondas por partida: ");
            rondasAux= input.next();
            if(rondasAux.matches("^[0-9]+$") && !rondasAux.matches("^0+$")){
                rondas = Integer.parseInt(rondasAux);
                modificado= true;
            }   
            else{
                err=true;
            }
            if(modificado) //Mensaje de confirmacion de cambio
            {
                try
                {
                    System.out.print('\u000C');
                    System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                                     "          -- Cambio realizado exitosamente! --");
                    Thread.sleep(1250);
                }
                catch(Exception e){
                }
            }
        }while(!((rondasAux.matches("^[0-9]+$") && !rondasAux.matches("^0+$"))|| rondasAux.equalsIgnoreCase("s")));
        return rondas;
    }

    public int modificarCambioAtaque()
    {
        int cambioAtaque = -1;    
        boolean err= false;
        boolean modificado= false;
        String cambioAtaqueAux;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            if(err){
                System.out.print(" Error! Digite un numero entre 0-100 o \"S\" para salir\n\n");
            }
            else{
                System.out.print(" (Digite S para salir)\n\n");
            }
            System.out.print(" -Digite el % de modificacion de ataque: ");
            cambioAtaqueAux= input.next();
            if(cambioAtaqueAux.matches("^[0-9]+$"))
            {
                if(-1<Integer.parseInt(cambioAtaqueAux)&&Integer.parseInt(cambioAtaqueAux)<101){
                    cambioAtaque = Integer.parseInt(cambioAtaqueAux);
                    modificado=true;
                }
                else{
                    err= true;
                }
            }   
            else{
                err=true;
            }
            if(modificado) //Mensaje de confirmacion de cambio
            {
                try
                {
                    System.out.print('\u000C');
                    System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                                     "          -- Cambio realizado exitosamente! --");
                    Thread.sleep(1250);
                }
                catch(Exception e){
                }
            }            
        }while(!((cambioAtaqueAux.matches("^[0-9]+$")&& -1<cambioAtaque&&cambioAtaque<101)|| cambioAtaqueAux.equalsIgnoreCase("s")));
        return cambioAtaque;
    }

    
    public void verMarcadores(double[] highscore, String[] highscorer)
    {  
        String salir;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+        
                             "         -*-*-*-*-*- Salon de la Fama -*-*-*-*-*-\n\n"+
                             "            1- "+highscorer[0]+"\t\t"+df.format(highscore[0])+"\n"+
                             "            2- "+highscorer[1]+"\t\t"+df.format(highscore[1])+"\n"+
                             "            3- "+highscorer[2]+"\t\t"+df.format(highscore[2])+"\n\n"+
                             "                 (Digite S para salir) ");            
            salir= input.next();           
        }while(!salir.equalsIgnoreCase("s"));
    }

    public String cambiarNombre(String nombrePrev)
    {
        String nombre= null;
        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
                         " (Digite S para salir)\n\n"+
                         " -Cual es el nombre de la proxima leyenda? ");
        nombre= input.next();
        if(!nombre.equals(nombrePrev)) //Mensaje de confirmacion de cambio
        {
            try
            {
                System.out.print('\u000C');
                System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                                 "          -- Nombre actualizado exitosamente! --");
                Thread.sleep(1250);
            }
            catch(Exception e){
            }
        }
        return nombre;        
    }

    public String opcionesCartas(Carta carta1,Carta carta2, Carta carta3){ 
        boolean err= false;
        String escoger="0";
        do{
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n");  
            if(err){          
                System.out.print(" Atencion! Digite una opcion valida o \"S\" para salir\n\n");
            }
            else{
                System.out.print(" (Digite S para salir)\n\n");
            }
            imprimirCartas(carta1);
            imprimirCartas(carta2);
            imprimirCartas(carta3);
            System.out.print("  -Digite el numero de la carta que desea(1-3):\n ");  
            escoger= input.next();
            if(!escoger.matches("[123sS]")){
                err= true;
            }
            else{
                err=false;
                if(escoger.equalsIgnoreCase("s"))
                {
                    escoger=cancelarPartida();
                    if(escoger.equalsIgnoreCase("n")){
                        err=true;
                    }
                }
            }
        }while(err);
        return escoger;
    }   
         
    public String cancelarPartida()
    {
        String escoger;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                         " *** Esta seguro que desea abandonar la partida? ***\n"+
                         "                        (S/N) ");
            escoger = input.next();
        }while((escoger.matches("[SsNn]")));
        return escoger;
    }
    
    public void imprimirCartas(Carta carta){
        System.out.print("        *- - - - - - - - - - - -*\n"+
                         "        |       "+carta.getNombre()+"\t\t|\n"+
                         "        |                       | \n"+
                         "        |     Ataque----"+carta.getAtaque()+"\t|\n"+
                         "        |                       | \n"+
                         "        |     Defensa---"+carta.getDefensa()+"\t|\n"+
                         "        |                       | \n"+
                         "        |     Elemento--"+carta.getElemento()+"\t|\n"+
                         "        *- - - - - - - - - - - -*\n");  
    }                                  
    
    public void luchaDeCartas(Carta carta1,Carta carta2){ //Hacer que se vea cool
        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        imprimirCartas(carta1);
        System.out.print("           ~~~ VS ~~~\n");
        imprimirCartas(carta2);
        System.out.print("\n            -Digite una tecla para continuar- ");
        input.next();
    }
    
    public void resultadoRonda(String score, int rondasRestantes)
    {
        try
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                             "  -Su puntaje despues de este enfrentamiento es:"+score+"\n");
            if(rondasRestantes==1){
                System.out.print("\n                   ** Ronda Final! **");
            }
            else
                if(rondasRestantes==0){
                    System.out.print("\n               ~~~ Gracias por jugar! ~~~");
                }
                else{
                    System.out.print("   Faltan "+rondasRestantes+" rondas!");
                }
            Thread.sleep(1500);
        }
        catch(Exception e){
        }                 
    }
    
    public void cambioMarcador()
    {
        try
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+
                             "\n\n      -- Felicidades, entraste al salon de la fama! --");
            Thread.sleep(1650);
        }
        catch(Exception e){
        }
    }
}
