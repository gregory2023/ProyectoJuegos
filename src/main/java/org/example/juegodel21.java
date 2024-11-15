package org.example;


import java.util.Scanner;
public class juegodel21 {

    public  static void main (String [] args){

        Scanner Entrada = new Scanner(System.in);

        //variables maqina
        int numeroMaquina=0;
        boolean banderaMaquina =true ;
        int sumaMaquina =0;
        int totalGanar=21;
        int sumaPerder;


        //variables para calcular la probabilidad
        int numerosPosibles=11;
        float probabilidad=0;
        int numerosPeligrosos=0;

        //variables jugador
        int numeroUsuario = 0;
        int suma = 0;
        String decision;         // Almacena la decisión del jugador ("si" o "no").
        int contador = 1;
        boolean banderaUsuario=true;


       numeroMaquina=(int)(Math.random()*11)+1;
       sumaMaquina=numeroMaquina;
       numeroUsuario = (int)(Math.random() * 11) + 1;


       System.out.println("INICIEMOS EL JUEGO DEL 21 !!");
       System.out.println("Primera carta tiene un valor de " + numeroMaquina);

        sumaPerder = totalGanar-sumaMaquina;

        //calcular la probabilidad -- punto clave del programa

        do {
            // Calcular la probabilidad de pasarse antes de tomar una nueva carta
            numerosPeligrosos = 0;
            for (int i = 1; i <= 11; i++) {
                if (sumaMaquina + i > 21) { // si la suma de maquina mas la carta con valor segun sea la iteracion (i) es mayor que 21 se incrementa numerospeligrosos
                    numerosPeligrosos++;
                }
            }
            probabilidad = ((float) numerosPeligrosos / (float) numerosPosibles) * 100; // calculo con numeros peligrosos y el total de los numeros 11
            System.out.println("Probabilidad de pasarse: " + probabilidad + "%");



            // plantarse según la probabilidad

            if (sumaMaquina == 21) {
                System.out.println("¡La máquina alcanza 21 y se planta automáticamente!");
                banderaMaquina = false; // La máquina se planta -- variable bandera


            } else if (probabilidad < 50.0) { // Bajo riesgo: toma carta si la probabilidad de pasarse es menor al 50%
                int nuevaCarta = (int) (Math.random() * 11) + 1;
                sumaMaquina += nuevaCarta;
                System.out.println("La máquina toma una carta: " + nuevaCarta + "\nSuma actual de la máquina: " + sumaMaquina);

            } else if (probabilidad >= 50.0 && probabilidad <= 80.0) {
                // Riesgo moderado: puede tomar una carta si no ha alcanzado 17 todavía

                if (sumaMaquina < 17) {
                    int nuevaCarta = (int) (Math.random() * 11) + 1;
                    sumaMaquina += nuevaCarta;
                    System.out.println("La máquina toma una carta (riesgo moderado): " + nuevaCarta + "\nSuma actual de la máquina: " + sumaMaquina);

                } else {
                    System.out.println("La máquina se planta con un total de: " + sumaMaquina);
                    banderaMaquina = false; // La máquina se planta--variable bandera
                }
            } else {
                // Alto riesgo: probabilidad > 80%, la máquina se planta
                System.out.println("La máquina decide plantarse por alto riesgo con un total de: " + sumaMaquina);
                banderaMaquina = false;  //La máquina se planta--variable bandera
            }

            // Si la máquina supera 21, pierde
            if (sumaMaquina > 21) {
                System.out.println("La máquina se pasó con un total de: " + sumaMaquina);
                banderaMaquina = false; //pierde -- sale con variable bandera
            }


        } while (banderaMaquina);

        //--------------- turno usuario ----------------------------

        // Mostrar la primera carta del jugador solo una vez
      if(sumaMaquina == 21){
          System.out.println("gracias por jugar !!");
      }else {

          System.out.println("Tu primera carta tiene un valor de " + numeroUsuario);
          suma += numeroUsuario;

          // Bucle del turno del jugador

          do {
              System.out.println("¿Quieres otra carta? (si/no)");
              decision = Entrada.nextLine().toLowerCase();

              while (!decision.equals("si") && !decision.equals("no")) {
                  System.out.println("Por favor ingresa 'si' o 'no': ");
                  decision = Entrada.nextLine().toLowerCase();
              }

              if (decision.equals("si")) {
                  // Si el jugador decide pedir otra carta
                  numeroUsuario = (int) (Math.random() * 11) + 1;
                  suma += numeroUsuario;

                  System.out.println("El valor de tu nueva carta es: " + numeroUsuario + "\nTu suma actual es: " + suma);

                  if (suma == 21) {
                      // Si el jugador alcanza 21
                      System.out.println("¡Felicidades! Has alcanzado 21 y ganado el juego.");
                      banderaUsuario = false; // Termina el turno del jugador --bandera jugador
                  } else if (suma > 21) {
                      // Si el jugador se pasa de 21
                      System.out.println("Lo siento, te pasaste con un total de: " + suma);
                      banderaUsuario = false; // Termina el turno del jugador --bandera jugador
                  }
              } else {
                  // Si el jugador decide plantarse
                  System.out.println("Te has plantado con un total de: " + suma);
                  banderaUsuario = false; // Termina el turno del jugador --bandera jugador
              }

          } while (banderaUsuario && suma <= 21);
      }



        //comprobacion

       if (sumaMaquina<21 && suma<21){ // si ninguno tiene mas de 21

           if (suma>sumaMaquina){
               System.out.println("felicitaciones jugador Ganasteeee con !! " +suma);
           }else if ((suma==sumaMaquina)){
               System.out.println("hay un empateee !");
           }else {
               System.out.println("la maquina ha ganadooooo con !" + sumaMaquina);
           }
       }else {
           System.out.println("gracias por jugar ");
       }

    }


}


