package com.company;

public class BeberVikingo implements Beber{
    @Override
    public Integer Beber(Integer millisBebidos){
        System.out.println("Cual gran Vikingo, toma el chopp de "+millisBebidos+" mililitros de cerveza y no deja ni una gota!");

        Integer residuos = millisBebidos;

        return residuos;
    }
}
