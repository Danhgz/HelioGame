import java.util.Scanner; 

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
            if(rondasAux.matches("^[0-9]+$") && !rondasAux.matches("^0+0*$")){
                rondas = Integer.parseInt(rondasAux);
            }   
            else{
                err=true;
            }
        }while(!((rondasAux.matches("^[0-9]+$") && !rondasAux.equals("0"))|| rondasAux.equalsIgnoreCase("s")));
        return rondas;
    }
    
    public int modificarHandicap()
    {
        int handicap = -1;    
        boolean err= false;
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
                }
                else{
                    err= true;
                }
            }   
            else{
                err=true;
            }
        }while(!((handicapAux.matches("^[0-9]+$")&& -1<handicap&&handicap<101)|| handicapAux.equalsIgnoreCase("s")));
        return handicap;
    }
    
    public void verMarcadores(double highscore, String highscorer)
    {  
        String salir;
        do
        {
            System.out.print('\u000C');
            System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"+        
                             "              ----- Salon de la Fama -----\n\n"+
                             "                1- "+highscorer+"\t"+highscore+"\n"+
                             "                2- "+highscorer+"\t"+highscore+"\n"+
                             "                3- "+highscorer+"\t"+highscore+"\n\n"+
                             "                 (Digite S para salir) ");
            salir= input.next();           
        }while(!salir.equalsIgnoreCase("s"));
    }
    
    public String cambiarNombre()
    {
        System.out.print('\u000C');
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~HELIO GAME~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
                         " (Digite S para salir)\n\n"+
                         " -Cual es el nombre de la proxima leyenda? ");  //Suena mal
        return input.next();           
    }
    
    public void imprimirCarta(String nombre, double ataque, double defensa, String elemento)
    {
        System.out.print(" - - - - - - - - - - - - -  \n"+
                         "|                         | \n"+
                         "        "+nombre+"       \n"+
                         "|                         | \n"+
                         "  Ataque----"+ataque+"   \n"+
                         "|                         | \n"+
                         "  Defensa---"+defensa+"  \n"+
                         "|                         | \n"+
                         "  Elemento--"+elemento+" \n"+
                         "|                         | \n"+
                         " - - - - - - - - - - - - -  \n");   
    }    
    
}
