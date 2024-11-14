package org.example;
import java.util.Scanner;
public class juegodel21 {

    public  static void main (String [] args){

        Scanner Entrada = new Scanner(System.in);

        int numeroMaquina=0;
        boolean bandera =true ;
        int sumaMaquina =0;
        int totalGanar=21;
        int sumaPerder;


        //variables para calcular la probabilidad
        int numerosPosibles=11;
        float probabilidad=0;
        int numerosPeligrosos=0;


        int numeroUsuario = 0;
        int suma = 0;
        String decision;         // Almacena la decisión del jugador ("si" o "no").
        int contador = 1;


       numeroMaquina=(int)(Math.random()*11)+1;
       sumaMaquina=numeroMaquina;
       numeroUsuario = (int)(Math.random() * 11) + 1;


       System.out.println("INICIEMOS EL JUEGO DEL 21 !!");
       System.out.println("Primera carta tiene un valor de " + numeroMaquina);



        sumaPerder = totalGanar-sumaMaquina;


        //calcular la probabilidad

        for (int i = 1; i <=11 ; i++) {

            if (sumaMaquina + i >21){
                numerosPeligrosos++;
            }
        }
        System.out.println(numerosPeligrosos);

        probabilidad =((float)numerosPeligrosos/(float) numerosPosibles )*100;


        System.out.println(probabilidad);





       /* System.out.println("Primera carta tiene un valor de " + numeroUsuario);

        // adicion a suma para el control de las cartas
        suma = suma + numeroUsuario;

        // Bucle que permite al jugador pedir más cartas o plantarse.
        do {


            System.out.println("¿Quieres otra carta? (si/no)");
            decision = Entrada.nextLine().toLowerCase();

            while (!decision.equals("si") && !decision.equals("no")){
                System.out.println("ingrese 'si' o 'no' por favor ");
                decision = Entrada.nextLine().toLowerCase();
            }

            // Si el jugador decide pedir otra carta:
            if (decision.equals("si")) {

                numeroUsuario = (int)(Math.random() * 11) + 1;
                suma = suma + numeroUsuario;


                System.out.println("El valor de la siguiente carta es de " + numeroUsuario);
                System.out.println("Llevas un valor de " + suma);

                // Incrementa el contador de cartas solicitadas.
                contador++;
            } else {

                decision = "no";
            }

            // Si el jugador ha alcanzado exactamente 21 puntos, gana automáticamente.
            if (suma == 21) {
                System.out.println("¡Has ganado!");
                System.out.println("Suma total: " + suma);
                break;
            }


        } while (suma <= 21 && decision.equals("si")); // El bucle se repite mientras la suma no supere 21 y el jugador quiera otra carta.


        if (suma >= 22) {

            System.out.println("Lo siento, has perdido.");
            System.out.println("Perdiste en la carta número " + contador);
        } else {
            // Si el jugador se planta sin pasarse, muestra el total y la cantidad de cartas solicitadas.
            System.out.println("Te plantaste con un valor de " + suma);
            System.out.println("Pediste un total de " + contador + " cartas.");
        }
*/
    }


}


