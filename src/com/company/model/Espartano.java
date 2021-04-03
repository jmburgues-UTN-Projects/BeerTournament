package com.company.model;

import com.company.Beber;
import com.company.Orinar;

public class Espartano extends Humano {

    Integer toleranciaExtra;


    public Espartano(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    public Espartano(String nombre, Integer edad, Integer peso, Orinar aOrinar, Beber aBeber, Integer toleranciaExtra) {
        super(nombre, edad, peso, aOrinar, aBeber);
        this.toleranciaExtra = toleranciaExtra > 8 ? 8 : toleranciaExtra; // limite maximo permitido
        this.toleranciaExtra = toleranciaExtra < 0 ? 0 : toleranciaExtra; // limite minimo permitido
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
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
    public String toString() {
        return "Soy " +
                nombre + '\'' +
                ", tengo " + edad +
                " años, y peso " + peso +
                "kg.";
    }
}
