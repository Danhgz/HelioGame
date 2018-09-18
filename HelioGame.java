import java.text.DecimalFormat;

public class HelioGame
{
    private Interfaz interfaz;
    private InterfazGUI interfazGui;
    private Carta cartaCompu;
    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Juez juez;
    private DecimalFormat df;

    private String[] highscorer;
    private double[] highscore; 
    private int cambioAtaque;//modificacion de peso de ataque
    private String cartaEl;
    private String jugador;
    private double score;
    private int rondas;              

    public HelioGame(char c)
    {
        if(c=='d'){
            interfaz = new Interfaz();
        }
        else{
            interfazGui = new InterfazGUI(); 
        }
        juez = new Juez();
        df = new DecimalFormat("0.00");
        highscorer = new String[]{"Nadie","Nadie","Nadie"};
        highscore = new double[]{0,0,0};
        jugador= "";
        cambioAtaque = 50;
        rondas = 5;        
    }

    public void correrGUI()
    {
        String op;
        do
        {
            op = interfazGui.imprimirMenuPrincipal(); //Cambiar
            switch(op)
            {
                case "1":
                rondas= interfazGui.modificarRondas(rondas);
                break;

                case "2":
                cambioAtaque= interfazGui.modificarCambioAtaque(cambioAtaque);
                break;

                case "3":
                correrMenuJuegoGUI();
                break;

                default:
                op="Salir";
            }
        }while(!op.equals("Salir"));
        System.exit(0);
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
                cambioAtaque= interfaz.modificarCambioAtaque();
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
        System.exit(0);
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
                if(jugador.equals("")){
                    jugador = interfaz.cambiarNombre(jugador);                     
                }
                if(!jugador.equals("")){
                    correrPartidaDOS();
                }
                break;

                case "4": break;

                default:
                err = true;
            }
        }while(!op.equals("4"));
    }

    public void correrMenuJuegoGUI()
    {
        String op;
        do
        {
            op = interfazGui.imprimirMenuJuego();
           
            switch(op)
            {
                case "1":
                interfazGui.verMarcadores(highscore,highscorer);
                break;

                case "2":
                jugador = interfazGui.cambiarNombre(jugador);
                break;

                case "3":
                if(jugador.equals("")){
                    jugador = interfazGui.cambiarNombre(jugador);                     
                }
                if(!jugador.equals("")){
                    correrPartidaGUI();
                }
                break;
                
                default:
                op="Salir";
            }
        }while(!op.equals("Salir"));
    }

    public void correrPartidaGUI()
    {
        score= 0.0;
        double primera=0.0;
        double segunda=0.0;
        for(int i=1; i<=rondas; ++i)
        {
            carta1= new Carta();
            carta2= new Carta();
            carta3= new Carta();
            cartaEl=interfazGui.opcionesCartas(carta1,carta2,carta3);
            if(cartaEl.equalsIgnoreCase("s")){
                i=rondas+1;
            }
            else
            {
                cartaCompu=new Carta ();
                if(cartaEl.equals("1"))
                {
                    interfazGui.luchaDeCartas(carta1,cartaCompu,jugador);
                    primera=juez.comparar(carta1,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta1,cambioAtaque);
                }
                if(cartaEl.equals("2"))
                {
                    interfazGui.luchaDeCartas(carta2,cartaCompu,jugador);
                    primera=juez.comparar(carta2,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta2,cambioAtaque);
                }
                if(cartaEl.equals("3"))
                {
                    interfazGui.luchaDeCartas(carta3,cartaCompu,jugador);
                    primera=juez.comparar(carta3,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta3,cambioAtaque);
                } 
                score+=primera-segunda;
                interfazGui.resultadoRonda(df.format(score),rondas-i);
            }
        }       
        if(!cartaEl.equalsIgnoreCase("s")){
            acomodarMarcadores(score);
        }        
    }
    public void correrPartidaDOS()
    {
        score= 0.0;
        double primera=0.0;
        double segunda=0.0;
        for(int i=1; i<=rondas; ++i)
        {
            carta1= new Carta();
            carta2= new Carta();
            carta3= new Carta();
            cartaEl=interfaz.opcionesCartas(carta1,carta2,carta3);
            if(cartaEl.equalsIgnoreCase("s")){
                i=rondas+1;
            }
            else
            {
                cartaCompu=new Carta ();
                if(cartaEl.equals("1"))
                {
                    interfaz.luchaDeCartas(carta1,cartaCompu,jugador);
                    primera=juez.comparar(carta1,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta1,cambioAtaque);
                }
                if(cartaEl.equals("2"))
                {
                    interfaz.luchaDeCartas(carta2,cartaCompu,jugador);
                    primera=juez.comparar(carta2,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta2,cambioAtaque);
                }
                if(cartaEl.equals("3"))
                {
                    interfaz.luchaDeCartas(carta3,cartaCompu,jugador);
                    primera=juez.comparar(carta3,cartaCompu,cambioAtaque);
                    segunda=juez.comparar(cartaCompu,carta3,cambioAtaque);
                } 
                score+=primera-segunda;
                interfaz.resultadoRonda(df.format(score),rondas-i);
            }
        }       
        if(!cartaEl.equalsIgnoreCase("s")){
            acomodarMarcadores(score);
        }        
    }

    public void acomodarMarcadores(double score)
    {
        boolean logro= false;
        if(score>highscore[0])
        {
            highscore[2]=highscore[1];
            highscorer[2]=highscorer[1];
            highscore[1]=highscore[0];
            highscorer[1]=highscorer[0];
            highscore[0]=score;
            highscorer[0]=jugador;
            logro= true;
        }
        else
        {
            if(score>highscore[1])
            {
                highscore[2]=highscore[1];
                highscorer[2]=highscorer[1];
                highscore[1]=score;
                highscorer[1]=jugador;
                logro= true;
            }
            else
            {
                if(score>highscore[2])
                {
                    highscore[2]=score;
                    highscorer[2]=jugador;
                    logro= true;
                }
            }
        }
        if(logro){
            interfazGui.cambioMarcador();
        }
    }
}

