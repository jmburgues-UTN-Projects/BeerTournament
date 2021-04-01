package com.company;

import com.company.model.Humano;

import java.util.ArrayList;
import java.util.List;

public class Torneo<A,B> {
    List<? extends Humano> equipoA;
    List<? extends Humano> equipoB;
    Integer cantRondas;
    Integer rondasRealizadas;
    Integer tamanioVasoML;

    public Torneo(List<? extends Humano> equipoA, List<? extends Humano>  equipoB, Integer cantRondas, Integer tamanioVasoML) {
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.cantRondas = cantRondas;
        this.tamanioVasoML = tamanioVasoML;
    }

    public void iniciar() {

       if(this.cantRondas<=0) {
            System.out.println("No hay rondas por realizar.");
        }else{
           System.out.println("\nInicia el Torneo! Rondas: " + this.cantRondas + ", tamaño del vaso: " + this.tamanioVasoML + " ml.");
           System.out.println("\nCon ustedes el primer equipo competidor:\n");
           this.equipoA.forEach((p) -> System.out.println(p.toString()));
           System.out.println("\nA continuacion, los competidores del equipo B!:\n");
           this.equipoB.forEach((p) -> System.out.println(p.toString()));

           if (equipoA.size() != equipoB.size()) {
               System.out.println("Parece que será una pelea desigual... o no?");
           }
        }
    }

    public List<? extends Humano> competir() {

        Humano competidorA;
        Humano competidorB;
        boolean orinadoB = false;
        boolean orinadoA = false;
        int count;
        int puntoA = 0;
        int puntoB = 0;

        this.rondasRealizadas = 0;
        List<Humano> ganadores = new ArrayList<>();
        int maxIntegrantes = equipoA.size() >= equipoB.size() ? equipoA.size() : equipoB.size();


        System.out.println("\nPresione ENTER para continuar.");
        new java.util.Scanner(System.in).nextLine();
        System.out.println("Comienza la competencia!!!");


        for (int rondas = this.rondasRealizadas; this.rondasRealizadas < cantRondas; this.rondasRealizadas++) {

            System.out.println("\n Ronda: " + (this.rondasRealizadas + 1) + " de " + this.cantRondas + ". Se enfrentan los participantes: ");

            for (int i = 0; i < maxIntegrantes; i++) {

                // asigno el competidor considerando las cantidades de cada equipo.
                competidorA = i < equipoA.size() ? equipoA.get(i) : equipoA.get(0);
                competidorB = i < equipoB.size() ? equipoB.get(i) : equipoB.get(0);

                System.out.println("\n-- Se enfrentan " + competidorA.getNombre() + " contra " + competidorB.getNombre() + "\n");
                count =1;

                while (!orinadoB && !orinadoA) {

                    System.out.println("Cerveza nro "+count);
                    System.out.print(competidorA.getNombre()+": ");
                    orinadoA = competidorA.beber(this.tamanioVasoML);

                    if(!orinadoA) {
                        System.out.print(competidorB.getNombre() +": ");
                        orinadoB = competidorB.beber(this.tamanioVasoML);
                    }

                    count++;
                    System.out.println("\nPresione ENTER para continuar.");
                    new java.util.Scanner(System.in).nextLine();

                }
                if(orinadoB){
                    System.out.println("\n Excelente por " + competidorA.getNombre() + "! Ha ganado la ronda!");
                    puntoA++;
                }else{
                    System.out.println("\n "+competidorB.getNombre()+" ha demostrado de lo que esta hecho y ha ganado la ronda!!");
                    puntoB++;
                }
                orinadoB = false;
                orinadoA = false;
            }
        }
        System.out.println("\n Puntos Equipo A: " + puntoA + ", Puntos Equipo B: " + puntoB +
                "\n" +
                "****** Y CON USTEDES LOS GANADORES DEL TORNEO ******");
        if(puntoA>puntoB) {
            System.out.println("\nExcelente por el Equipo A !! Han sabido demostrar como se bebe.");
            System.out.println("\nPresione ENTER para continuar.");
            new java.util.Scanner(System.in).nextLine();
            return equipoA;
        }else{
            System.out.println("\nExcelente por el Equipo B !! Han sabido demostrar como se bebe.");
            System.out.println("\nPresione ENTER para continuar.");
            new java.util.Scanner(System.in).nextLine();
            return equipoB;
        }
    }
}