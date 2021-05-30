package junior.pedroso.rodrigo.appfragments.gson_class;

import java.util.List;

public class Random{
    public List<junior.pedroso.rodrigo.appfragments.gson_class.Result> results;
    public String nationality;
    public String seed;
    public String version;

    public List<junior.pedroso.rodrigo.appfragments.gson_class.Result> getResults() {
        return results;
    }

    public void setResults(List<junior.pedroso.rodrigo.appfragments.gson_class.Result> results) {
        this.results = results;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
