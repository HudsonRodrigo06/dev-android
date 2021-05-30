package junior.pedroso.rodrigo.appcep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText etCEP, etEndereco;
    private Button btBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCEP = findViewById(R.id.etCEP);
        etEndereco = findViewById(R.id.etEndereco);
        btBuscar = findViewById(R.id.btBuscar);

        btBuscar.setOnClickListener(e->{buscarCep();});
    }

    private void buscarCep() {
        AcessaWSTask task = new AcessaWSTask();

        try {
            String sJson = task.execute("https://viacep.com.br/ws/" + etCEP.getText() + "/json/").get();

//            JSONObject oJson = new JSONObject(sJson);
//
//            etEndereco.setText(oJson.getString("logradouro") + "," +
//                    oJson.getString("localidade") + "," +
//                    oJson.getString("uf"));



            // String JSON para object
            Gson gson = new Gson();
            CEP cep = gson.fromJson(sJson, CEP.class);

            etEndereco.setText(cep.getLogradouro() + "," +
                      cep.getLocalidade() + "," +
                      cep.getUf());

            // Object para string Json
            // gson.toJson(cep)



        }
        catch(Exception e){
            etEndereco.setText(e.getMessage());
        }
    }
}