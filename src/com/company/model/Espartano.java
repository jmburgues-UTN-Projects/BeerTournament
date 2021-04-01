package com.company.model;

import com.company.Beber;
import com.company.Orinar;

public class Espartano extends Humano {

    public Espartano(String nombre, Integer edad, Integer peso, Orinar aOrinar, Beber aBeber) {
        super(nombre, edad, peso, aOrinar, aBeber);
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
