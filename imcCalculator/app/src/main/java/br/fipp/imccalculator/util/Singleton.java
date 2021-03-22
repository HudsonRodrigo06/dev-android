package br.fipp.imccalculator.util;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    static private List<Medida> medidas = new ArrayList<>();

    private Singleton() {

    }

    public static List<Medida> getMedidas() {
        return medidas;
    }
}
