package br.fipp.imccalculator.util;

import java.text.DecimalFormat;

public class Calculos {



    public static double IMC(double peso, double altura){
        return peso/Math.pow(altura, 2);
    }

    public static String getResultado(double imc){


        String res = "";

        if(imc < 18.6)
            res = "MAGREZA";
        else if(imc < 25)
            res = "NORMAL";
        else if(imc < 30)
            res = "SOBREPESO";
        else if (imc < 40)
            res = "OBESIDADE GRAU II";
        else
            res = "OBESIDADE GRAVE";

        return res;
    }
}
