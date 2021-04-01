package com.company.model;

import com.company.Beber;
import com.company.Orinar;

public abstract class Humano {
    String nombre;
    Integer edad;
    Integer peso;
    Vejiga vejiga;
    Orinar aOrinar;
    Beber aBeber;

    public Humano(){}

    public Humano(String nombre, Integer edad, Integer peso, Orinar aOrinar, Beber aBeber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.aOrinar = aOrinar;
        this.aBeber = aBeber;
        this.vejiga = new Vejiga();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Orinar getaOrinar() {
        return aOrinar;
    }

    public void setaOrinar(Orinar aOrinar) {
        this.aOrinar = aOrinar;
    }

    public Beber getaBeber() {
        return aBeber;
    }

    public void setaBeber(Beber aBeber) {
        this.aBeber = aBeber;
    }

    public boolean orinar() {
        vejiga.vaciar();
        return this.aOrinar.Orinar();
    }

    public boolean beber(Integer millisBebidos){
        boolean orinado = false;
        Integer residuos = this.aBeber.Beber(millisBebidos);
        vejiga.nuevoVolumen(residuos);
        if(vejiga.isLlena()){
            orinado = orinar();
        }

        return orinado;
    }

}
