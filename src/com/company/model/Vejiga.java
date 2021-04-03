package com.company.model;

public class Vejiga {
    Integer capacidadMax;
    Integer volumenActual;
    boolean vejigaLlena;

    public Vejiga(){
        this.capacidadMax = 1800;
        this.volumenActual = 0;
        this.vejigaLlena = false;

    }
    public void nuevoVolumen(Integer volumen){
        if(volumen+volumenActual >= capacidadMax){
            vejigaLlena = true;
            volumenActual = capacidadMax;
        }else{
            vejigaLlena = false;
            volumenActual += volumen;
        }
    }
    public boolean isLlena(){
        return vejigaLlena;
    }

    public void vaciar(){
        volumenActual = 0;
    }

    public Integer getVolumen(){
        return volumenActual;
    }

    public Integer getCapacidadMax(){
        return this.capacidadMax;
    }
}
