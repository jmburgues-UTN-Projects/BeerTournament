package com.company;

import java.util.Random;

public class BeberEspertano implements Beber{
    public Integer Beber(Integer millisBebidos){

        Integer residuos = millisBebidos;
        System.out.println("Bebe "+millisBebidos+" mililitros de cerveza, como buen Espartano! ");

        return residuos;
    }
}
