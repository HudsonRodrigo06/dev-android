package junior.pedroso.rodrigo.hudson.util;

import java.io.Serializable;

public class Compra implements Serializable {
    private String item;
    private int qtde;
    private String un_medida;

    public Compra(String item, int qtde, String un_medida) {
        this.item = item;
        this.qtde = qtde;
        this.un_medida = un_medida;
    }

    public Compra() {
        this("", 0, "");
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getUn_medida() {
        return un_medida;
    }

    public void setUn_medida(String un_medida) {
        this.un_medida = un_medida;
    }

    @Override
    public String toString() {
        return this.qtde + this.un_medida + " " + this.item;
    }
}
