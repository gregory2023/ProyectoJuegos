package org.example;

import java.util.Scanner;

public class juegoBatallaNumeros {


  //utilizamos variables globales para reutilizar y tener el codigo mas escalable
        public static Scanner Entrada;
        public static int numeroJugador;
        public static int numereroMaquina;
        public static String nombre;
        public static int puntos;
        public static int partida;
        public static int partidasGanadas;
        public static int recompensa;

        public static int resta;

        public static boolean poderRestar=false;
        public static boolean poderDoblar=false;
        public static boolean poderRobar=false;


        public static void main(String[] args) {
            System.out.println("HOLA COMO TE LLAMAS ? ");
            nombre = Entrada.nextLine();
            System.out.println(" CADA INTENTO TIENE TRES RONDAS Y CADA INTENTO GANADO TIENE UN RECOMPENSA DE 400 PUNTOS ");
            inicioJuego();
        }

        private static void inicioJuego() {
            if (puntos >= 200) {
                puntos -= partida;
                jugador();
            } else {
                System.out.println("LO SIENTO YA NO TIENES MAS PUNTOS SUFICIENTES\n QUIERES RECARGAR (SI/NO)");
                finJuego();
            }

        }

        private static void jugador() {
            for(int i = 1; i <= 3; ++i) {
                System.out.println("----------------------------------------------------------------------\nturno de jugador");
                numeroJugador = (int)(Math.random() * 12.0) + 1;
                numereroMaquina = (int)(Math.random() * 12.0) + 1;
                System.out.println(nombre + " TU NUMERO ASIGNADO ES  " + numeroJugador);
                System.out.println(" maquina TU NUMERO ASIGNADO ES  " + numereroMaquina);
                boolean poderUtilizado = false;

                do {
                    System.out.println(" QUIERES UTILIZAR UN PODER  (SI/NO) ? \nRECUERDA SOLO TIENES UN PODER POR RONDA ");
                    String desicionPoder = Entrada.nextLine();
                    if (!desicionPoder.equals("si") && !desicionPoder.equals("SI")) {
                        if (desicionPoder.equals("no") || desicionPoder.equals("NO")) {
                            System.out.println("VALE , JUEGAS SIN PODER");
                        }
                    } else {
                        System.out.println("GENIAL AQUI TIENES TUS PODERES \n1.RESTAR VALOR CONTRINCANTE \n2.DOBLAR NUMERO \n3.ROBAR NUMERO CONTRINCANTE");
                        int opc = Entrada.nextInt();
                        Entrada.nextLine();//LIMPIA EL SCANNER PARA QUE PUEDA RECIBIR OTRO TIPOS DE DATOS
                        switch (opc) {
                            case 1:
                                System.out.println("ESTE PODER RESTA DE FORMA ALEATORIA EL VALOR DE MAQUINA CON UN VALOR DEL 1 al 7 \nACEPTAS (1.SI/2.NO) - INGRESA EL NUMERO");
                                int desicionPoderResta = Entrada.nextInt();
                                resta=(int)(Math.random()*7)+1;
                                Entrada.nextLine();
                                if (desicionPoderResta == 1) {
                                    numereroMaquina -= resta;
                                    System.out.println("PODER APLICADO");

                                    poderRestar = true;
                                    poderUtilizado = true;
                                } else {
                                    System.out.println("VALE, VUELVES AL MENU INICIAL :) ");
                                }
                                break;
                            case 2:
                                numeroJugador *= 2;
                                System.out.println(" PODER APLICADO , NUMERO POTENCIADO ES IGUAL A :  " + numeroJugador);

                                poderDoblar=true;
                                poderUtilizado = true;
                                break;
                            case 3:
                                numeroJugador = numereroMaquina;
                                System.out.println("PODER APLICADO, AHORA TU NUMERO ROBADO ES :" + numereroMaquina);

                                poderRobar=true;
                                poderUtilizado = true;
                                break;
                            default:
                                System.out.println("VALOR INCORRECTO");
                        }
                    }
                } while(!poderUtilizado);

                maquina();
                operacion();
            }

            sumaPuntos();
        }

        public static void maquina() {



            System.out.println("----------------------------------------------------------------------\nturno de maquina");
            int decision = (int)(Math.random() * 3.0) + 1;
            switch (decision) {
                case 1:
                    if (poderRestar==true){

                        System.out.println(" PODER -RESTAR- NO DISPONIBLE , USUARIO YA LO UTILIZO");
                        System.out.println("QUIERES UTILIZAR OTRO PODER (SI/NO)");

                        decision = (int)(Math.random() * 2.0) + 1;
                        switch (decision){
                            case 1:
                                System.out.println("MAQUINA A ELEGIDO  DOBLAR SU NUMERO  ");
                                numereroMaquina *= 2;
                                break;

                            case 2:
                                System.out.println("MAQUINA A ELEGIDO ROBAR TU NUMERO ");
                                numereroMaquina = numeroJugador;
                                break;
                        }

                    }else {

                        System.out.println("MAQUINA A ELEGIDO EL PODER DE RESTAR TU NUMERO ");
                        resta=(int)(Math.random()*7)+1;
                        numeroJugador -= resta;
                    }
                    break;

                case 2:
                    if (poderDoblar==true){

                        System.out.println("PODER -DOBLAR- NO DISPONIBLE , USUARIO YA LO UTILIZO");
                        System.out.println("QUIERES UTILIZAR OTRO PODER (SI/NO)");
                        decision = (int)(Math.random() * 2.0) + 1;
                        switch (decision){
                            case 1:
                                System.out.println("MAQUINA A ELEGIDO EL PODER DE RESTAR TU NUMERO ");
                                resta=(int)(Math.random()*7)+1;
                                numeroJugador -= resta;
                                break;

                            case 2:
                                System.out.println("MAQUINA A ELEGIDO ROBAR TU NUMERO ");
                                numereroMaquina = numeroJugador;
                                break;
                        }


                    }else {

                        if (numereroMaquina <= 10) {
                            System.out.println("MAQUINA A ELEGIDO  DOBLAR SU NUMERO  ");
                            numereroMaquina *= 2;
                        }
                    }
                    break;

                case 3:
                    if (poderRobar==true){

                        System.out.println("PODER -ROBAR- NO DISPONIBLE , USUARIO YA LO UTILIZO");
                        System.out.println("QUIERES UTILIZAR OTRO PODER (SI/NO)");
                        decision = (int)(Math.random() * 2.0) + 1;
                        switch (decision){
                            case 1:
                                System.out.println("MAQUINA A ELEGIDO EL PODER DE RESTAR TU NUMERO ");
                                resta=(int)(Math.random()*7)+1;
                                numeroJugador -= resta;
                                break;

                            case 2:
                                System.out.println("MAQUINA A ELEGIDO ROBAR TU NUMERO ");
                                numereroMaquina = numeroJugador;
                                break;
                        }

                    }else{

                        System.out.println("MAQUINA A ELEGIDO ROBAR TU NUMERO ");
                        numereroMaquina = numeroJugador;
                    }

                    break;

                default:

                    System.out.println("ERROR CAPA 8");
            }

        }

        public static void operacion() {
            if (numeroJugador > numereroMaquina) {
                ++partida;
                System.out.println(nombre + "tu numero es " + numeroJugador);
                System.out.println("maquina tu numeroe es " + numereroMaquina);
                System.out.println("GANA " + nombre);
            } else if (numeroJugador == numereroMaquina) {
                System.out.println(nombre + "tu numero es " + numeroJugador);
                System.out.println("maquina tu numeroe es " + numereroMaquina);
                System.out.println("empate");
            } else {
                System.out.println(nombre + "tu numero es " + numeroJugador);
                System.out.println("maquina tu numeroe es " + numereroMaquina);
                System.out.println("gana maquina ");
            }

        }

        public static void sumaPuntos() {
            if (partidasGanadas > 2) {
                puntos += 400;
            } else {
                System.out.println("RONDA PERDIDA ");
                System.out.println("quieres volver a jugar (si/no");
                String desicion = Entrada.nextLine();
                if (!desicion.equals("si") && !desicion.equals("SI")) {
                    finJuego();
                } else {
                    inicioJuego();
                }
            }

        }

        public static void finJuego() {
            System.out.println("gracias ");
        }

        static {
            Entrada = new Scanner(System.in);
            puntos = 200;
            partida = 200;
            partidasGanadas = 0;
        }
}

