package junior.pedroso.rodrigo.appfragments.util;

import junior.pedroso.rodrigo.appfragments.gson_class.Random;
import junior.pedroso.rodrigo.appfragments.gson_class.Result;

public class Singleton {

    static private Filtro filtro = new Filtro();
    static private Random rand = new Random();

    private Singleton() {

    }

    public static Filtro getFiltro() {
        return filtro;
    }

    public static void setFiltro(Filtro filtro) {
        junior.pedroso.rodrigo.appfragments.util.Singleton.filtro = filtro;
    }

    public static Random getRandom() {
        return rand;
    }

    public static void setResult(Random rand) {
        junior.pedroso.rodrigo.appfragments.util.Singleton.rand = rand;
    }
}
