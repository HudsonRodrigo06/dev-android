package br.fipp.imccalculator.util;

public class Medida {

    private double peso;
    private double altura;
    private double imc;
    private String condicao;

    public Medida(double peso, double altura, double imc, String condicao) {
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.condicao = condicao;
    }

    public Medida() {
        this(0,0,0,"");
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    @Override
    public String toString() {
        return "Medida{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", imc=" + imc +
                ", condicao='" + condicao + '\'' +
                '}';
    }
}
