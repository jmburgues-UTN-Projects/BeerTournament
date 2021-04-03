package com.company.model;

import com.company.Beber;
import com.company.Orinar;

public class Vikingo extends Humano {

    boolean vejigaExtraUtilizada;

    public Vikingo(String nombre, Integer edad, Integer peso, Orinar aOrinar, Beber aBeber) {
        super(nombre, edad, peso, aOrinar, aBeber);
        this.vejigaExtraUtilizada = false;
    }

    @Override
    public boolean orinar() {
        boolean orinado;

        if(!vejigaExtraUtilizada){
            orinado = false;
            System.out.println("** Utiliza su capacidad heredada de ancestros Vikingos. Su vejiga ya no se siente hinchada. **");
            this.vejigaExtraUtilizada = true;
        }
        else{
            orinado = this.aOrinar.Orinar();
        }

        this.vejiga.vaciar();

        return orinado;
    }


    @Override
    public String toString() {
        return "Soy " +
                nombre + '\'' +
                ", tengo " + edad +
                " años, y peso " + peso +
                "kg.";
    }
}
