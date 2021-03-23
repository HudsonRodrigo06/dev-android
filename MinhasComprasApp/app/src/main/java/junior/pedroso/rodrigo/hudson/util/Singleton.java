package junior.pedroso.rodrigo.hudson.util;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    static private Carrinho carrinho = new Carrinho();

    private Singleton() {

    }

    public static Carrinho getCarrinho() {
        return carrinho;
    }

    public static void setCarrinho(Carrinho carrinho) {
        Singleton.carrinho = carrinho;
    }
}
