package br.fipp.appcepretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.fipp.appcepretrofit.util.Cep;
import br.fipp.appcepretrofit.util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etcep, etresult;
    private Button btpesquisar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etcep=findViewById(R.id.etcep);
        etresult=findViewById(R.id.etresult);
        btpesquisar=findViewById(R.id.btpesquisar);
        btpesquisar.setOnClickListener(e->{buscaCep();});
    }

    private void buscaCep() {
        Call<Cep> call = new RetrofitConfig().getCEPService().
                buscarCEP(etcep.getText().toString());
        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                Cep cep = response.body();
                etresult.setText(cep.logradouro+"\n"+cep.localidade+"-"+cep.uf);
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                etresult.setText("Erro ao acessar o serviço\n"+call.toString()+
                        "\n"+t.getMessage());
            }
        });

    }
}