package br.fipp.appcepretrofit.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;
    public RetrofitConfig() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit=new Retrofit.Builder().baseUrl("http://viacep.com.br/ws/").
                addConverterFactory(GsonConverterFactory.create()).build();
    }
    public CepService getCEPService() {
        return this.retrofit.create(CepService.class);
    }
}
