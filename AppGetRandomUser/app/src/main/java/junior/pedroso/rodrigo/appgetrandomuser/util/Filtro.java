package junior.pedroso.rodrigo.appgetrandomuser.util;

public class Filtro {
    private String genero;
    private String localidade;

    public Filtro() {
        this.genero = "female";
        this.localidade = "US";
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
