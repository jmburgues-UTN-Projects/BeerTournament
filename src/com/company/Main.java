package com.company;

import com.company.model.Espartano;
import com.company.model.Humano;
import com.company.model.Tabernero;
import com.company.model.Vikingo;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        final Integer PESO_MAXIMO = 130;
        final Integer PESO_MINIMO = 70;
        final Integer EDAD_MAXIMA = 40;
        final Integer EDAD_MINIMA = 20;

        List<Vikingo> equipoVikingo = new ArrayList<>();
        List<Espartano> equipoEspartano = new ArrayList<>();

    // Creo los dos equipos

        for(int i=0;i<3;i++){
            equipoVikingo.add(new Vikingo(("Vikingo" + i),
                                            (int)(Math.random() * (EDAD_MAXIMA - EDAD_MINIMA +1) + EDAD_MINIMA),
                                            (int)(Math.random() * (PESO_MAXIMO - PESO_MINIMO +1) + PESO_MINIMO),
                                            new OrinarVikingo(),
                                            new BeberVikingo()));


            equipoEspartano.add(new Espartano(("Espartano" + i),
                                                (int)(Math.random() * (EDAD_MAXIMA - EDAD_MINIMA +1) + EDAD_MINIMA),
                                                (int)(Math.random() * (PESO_MAXIMO - PESO_MINIMO +1) + PESO_MINIMO),
                                                new OrinarEspartano(),
                                                new BeberEspertano(),(i*5)));
        }

    // Los ordeno por Peso

        Comparator<Humano> comparadorPorPeso = new Comparator<Humano>() {
            @Override
            public int compare(Humano o1, Humano o2) {
                return o1.getPeso().compareTo(o2.getPeso());
            }
        };

        Collections.sort(equipoVikingo,comparadorPorPeso);
        Collections.sort(equipoEspartano,comparadorPorPeso);

    // Creo un Torneo y los hago competir entre ellos.

        Torneo deVerano = new Torneo(equipoEspartano,equipoVikingo,1,600);

        List<Humano> ganadores = new ArrayList<>();

        System.out.println("\n\nAl sur del Copenhage, en una taberna cerca del mar..." +
                "\n ¡¡TORNEO DE FRESCAS!!\n" +
                "\n-Vikingos y Espartanos se enfrentaran a un torneo de cervezas donde deberan tomar por rondas. " +
                "El primero que vaya a orinar pierde!" +
                "\nLos Vikingos son conocidos por su alta resistencia. " +
                "Tienen una 'vejiga extra' que pueden utilizar solo una vez." +
                "\nLos Espartanos, por otro lado, tienen una alta probabilidad de absorver completamente lo que beban" +
                " sin que vaya a parar en su vejiga. \nQuien ganara? Ya lo veremos...");

        deVerano.iniciar();
        ganadores = deVerano.competir();

    // El Tabernero quiere hacer añicos a los ganadores

        Tabernero elTabernero = new Tabernero("Borg el Tabernero",50,130,new OrinarVikingo(),new BeberEspertano());
        List<Humano> asociacionMutualDeTaberneros = new ArrayList<>();
        asociacionMutualDeTaberneros.add(elTabernero);

        System.out.println("** Borg, el tabernero, desafia a los ganadores.\n Mitad Espartano, mitad Vikingo tiene lo mejor de cada uno de ellos. **");

        Torneo granFinal = new Torneo(ganadores,asociacionMutualDeTaberneros,1,600);
        granFinal.iniciar();
        ganadores = granFinal.competir(); // Que gane el mejor!

        if(ganadores.get(0).equals(elTabernero)) {
            System.out.println("- Muaajaja! Los aplasté como las ratas que son!");
        }
        else{
            System.out.println(" ** Borg el Tabernero llora desconsolado y sale corriendo del lugar...");
        }
    }
}
