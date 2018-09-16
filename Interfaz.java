import java.util.Scanner; 
import java.util.concurrent.TimeUnit;

public class Interfaz 
{
    private Scanner input;
    
    public Interfaz()
    {
        input = new Scanner (System.in);
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
                    System.out.print("\n\n -- Cambio realizado exitosamente! --");
                    Thread.sleep(1250);
                }
                catch(Exception e){
                }
            }
        }while(!((rondasAux.matches("^[0-9]+$") && !rondasAux.matches("^0+$"))|| rondasAux.equalsIgnoreCase("s")));
        return rondas;
    }
    
    public int modificarHandicap()
    {
        int handicap = -1;    
        boolean err= false;
        boolean modificado= false;
        String handicapAux;
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
            handicapAux= input.next();
            if(handicapAux.matches("^[0-9]+$"))
            {
                if(-1<Integer.parseInt(handicapAux)&&Integer.parseInt(handicapAux)<101){
                    handicap = Integer.parseInt(handicapAux);
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
                    System.out.print("\n\n -- Cambio realizado exitosamente! --");
                    Thread.sleep(1250);
                }
                catch(Exception e){
                }
            }            
        }while(!((handicapAux.matches("^[0-9]+$")&& -1<handicap&&handicap<101)|| handicapAux.equalsIgnoreCase("s")));
        return handicap;
    }
    
    public void verMarcadores(double[] highscore, String[] highscorer)
    {  
        String salir;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+        
                             "         -*-*-*-*-*- Salon de la Fama -*-*-*-*-*-\n\n"+
                             "            1- "+highscorer[0]+"\t\t"+highscore[0]+"\n"+
                             "            2- "+highscorer[1]+"\t\t"+highscore[1]+"\n"+
                             "            3- "+highscorer[2]+"\t\t"+highscore[2]+"\n\n"+
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
                System.out.print("\n\n -- Nombre actualizado exitosamente! --");
                Thread.sleep(1250);
            }
            catch(Exception e){
            }
        }
        return nombre;        
    }
    
    public void imprimirCartas()
    {
        Cartas carta1 = new Cartas();
        Cartas carta2 = new Cartas();
        Cartas carta3 = new Cartas();
        System.out.print(" - - - - - - - - - - - - -  \n"+
                         "|                         | \n"+
                         "        "+carta1.getNombre()+"       \n"+
                         "|                         | \n"+
                         "  Ataque----"+carta1.getAtaque()+"   \n"+
                         "|                         | \n"+
                         "  Defensa---"+carta1.getDefensa()+"  \n"+
                         "|                         | \n"+
                         "  Elemento--"+carta1.getElemento()+" \n"+
                         "|                         | \n"+
                         " - - - - - - - - - - - - -  \n");   
    }    
    
}
