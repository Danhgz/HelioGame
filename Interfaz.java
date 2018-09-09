/**
 * Write a description of class Interfaz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner; 

public class Interfaz {
        public void imprimirMenu1() {
        System.out.print("                     HELIO GAME                       \n"+
                         "~~~~~~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
                         "                                                       \n"+
                         "1. Indicar cantidad de enfrentamientos por juegos      \n"+
                         "2. Indicar porcentaje de modificacion de peso de ataque\n"+
                         "3. Iniciar un juego nuevo                              \n"+
                         "4. Salir                                               \n");
    }

    public void imprimirMenu2() {
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
                         "                                                       \n"+
                         "1. Ver usuario y puntaje maximo                        \n"+
                         "2. Cambiar nombre del jugador                          \n"+
                         "3. Iniciar partida                                     \n"+
                         "4. Salir                                               \n");
    }


    public int pedirInt(String enunciadoprovisional){
        Scanner entrada = new Scanner (System.in);
        System.out.print(falta);
        int numero = entrada.nextInt();
        return numero; 
    }

    public String pedirString(String enunciadoprovisional){
        Scanner entrada = new Scanner (System.in);
        System.out.print (falta);
        String input = entrada.nextLine();
        return input; 
    }

    }



