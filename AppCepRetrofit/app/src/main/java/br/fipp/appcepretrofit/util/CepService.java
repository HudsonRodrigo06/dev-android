package br.fipp.appcepretrofit.util;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("{cep}/json")
    Call<Cep> buscarCEP(@Path("cep") String cep);

}

