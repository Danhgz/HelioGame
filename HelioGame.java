public class HelioGame
{
    private Interfaz interfaz;
    private InterfazGUI interfazGui;
    private String cartaEl;
    private String jugador;
    private double[] highscore; 
    private String[] highscorer; 
    private int rondas;
    private int handicap;//modificacion de peso de ataque     
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Carta cartaElegida=new Carta();
    private Carta cartaCompu;

    public HelioGame(char c)
    {
        if(c=='d'){
            interfaz = new Interfaz();
        }
        else{
            interfazGui = new InterfazGUI(""); //No sé que va ahi
        }
        jugador= null;
        highscorer = new String[]{"Daniel Henao","Sergia Marquina","Jose Vacas"};
        highscore = new double[]{752.52,1313,6969};
        rondas = 5;
        handicap = 50;
    }

    public void correrGUI()
    {
        String op;
        boolean err = false;
        do
        {
            op = interfaz.imprimirMenuPrincipal(err); //Cambiar
            err = false;
            switch(op)
            {
                case "1":
                //rondas= interfaz.modificarRondas();
                break;

                case "2":
                //handicap= interfaz.modificarHandicap();
                break;

                case "3":
                //correrMenuJuegoDOS();
                break;

                case "4":
                System.out.println('\u000C');    
                System.out.println("~~~~~~~~~~~~ Gracias por jugar, hasta luego! :) ~~~~~~~~~~~");
                break;                 

                default:
                err = true;                        
            }
        }while(!op.equals("4"));
    }

    public void correrDOS()
    {
        String op;
        boolean err = false;
        do
        {
            op = interfaz.imprimirMenuPrincipal(err);
            err = false;
            switch(op)
            {
                case "1":
                    rondas= interfaz.modificarRondas(); 
                    break;
            
                case "2":
                    handicap= interfaz.modificarHandicap();
                    break;                

                case "3":
                    correrMenuJuegoDOS();
                    break;

                case "4":
                    System.out.println('\u000C');    
                    System.out.println("~~~~~~~~~~~~ Gracias por jugar, hasta luego! :) ~~~~~~~~~~~");
                    break;                 

                default:
                    err = true;                        
            }
        }while(!op.equals("4"));
    }

    public void correrMenuJuegoDOS()
    {
        String op;
        boolean err = false;
        do
        {
            op = interfaz.imprimirMenuJuego(err);
            err = false;
            switch(op)
            {
                case "1":
                    interfaz.verMarcadores(highscore,highscorer);
                    break;

                case "2":
                    jugador = interfaz.cambiarNombre(jugador);
                    break;
    
                case "3":
                    if(jugador==null){
                        jugador = interfaz.cambiarNombre(jugador);
                    }
                    carta1= new Carta();
                    carta2= new Carta();
                    carta3= new Carta();
                    cartaEl=interfaz.opcionesCartas(carta1,carta2,carta3);
                    cartaCompu=new Carta ();                        //ERROR PORQUE ESTA PICHA NO ENTRA A NINGUN IF 
                                                                //SDFMSDKLAFNKLASDFNKLSDNFASDFSDA
                                                                //SDFASKFLSDJASDKLFSJADFKLJSDAFFFFFFFF
                    if(cartaEl.equals("1")){
                        interfaz.luchaDeCartas(carta1,cartaCompu);
                    }
                    if(cartaEl.equals("2")){
                        interfaz.luchaDeCartas(carta2,cartaCompu);
                    }
                    if(cartaEl.equals("3")){
                        interfaz.luchaDeCartas(carta3,cartaCompu);
                    }
                    interfaz.luchaDeCartas(cartaElegida,cartaCompu);
                    break;
                    
                case "4": break;

                default:
                    err = true;
            }
        }while(!op.equals("4"));
    }

}
