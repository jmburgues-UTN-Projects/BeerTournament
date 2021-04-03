package com.company.model;

import com.company.Beber;
import com.company.Orinar;

public class Tabernero extends Humano {

    Integer toleranciaExtra;
    boolean vejigaExtraUtilizada;


    public Tabernero(String nombre, Integer edad, Integer peso, Orinar aOrinar, Beber aBeber) {
        super(nombre, edad, peso, aOrinar, aBeber);
        this.toleranciaExtra = 4;
        this.vejigaExtraUtilizada = false;
    }

    @Override
    public boolean beber(Integer millisBebidos){
        boolean orinado = false;
        Integer probabilidadTolerancia =  (int)(Math.random() * (10 - 1 +1) + 1);
        Integer residuos = this.aBeber.Beber(millisBebidos);

        if(probabilidadTolerancia < this.toleranciaExtra){
            System.out.println("** Utiliza su tolerancia espartana y soporta la bebida **");
            residuos = 0;
        }

        this.vejiga.nuevoVolumen(residuos);

        if(this.vejiga.isLlena()){
            orinado = orinar();
        }

        return orinado;
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
