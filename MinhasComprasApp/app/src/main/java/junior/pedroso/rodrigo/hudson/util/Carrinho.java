package junior.pedroso.rodrigo.hudson.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable {

    List <Compra> lista;

    public Carrinho() {
        this.lista = new ArrayList<>();
    }

    public void addCompra(Compra c){
        this.lista.add(c);
    }

    public List<Compra> getLista() {
        return lista;
    }
}
