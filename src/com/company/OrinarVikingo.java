package com.company;

public class OrinarVikingo implements Orinar {
    boolean vejigaExtraUsada = false;

    @Override
    public boolean Orinar() {
        boolean orina = true;
        if (!vejigaExtraUsada) {
            vejigaExtraUsada = true;
            orina = false;
            System.out.println("** Utiliza su capacidad heredada de ancestros Vikingos. Su vejiga ya no se siente hinchada. **");
        } else {
            System.out.println("**Sale corriendo directo a orinar...**");
            vejigaExtraUsada = false;
        }
        return orina;
    }
}
