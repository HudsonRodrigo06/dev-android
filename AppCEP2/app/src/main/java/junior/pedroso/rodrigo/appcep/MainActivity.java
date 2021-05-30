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

        // linka elementos
        etCEP = findViewById(R.id.etCEP);
        etEndereco = findViewById(R.id.etEndereco);
        btBuscar = findViewById(R.id.btBuscar);

        // evento ao clicar em buscar
        btBuscar.setOnClickListener(v -> { buscarCEP(); });


    }

    private void buscarCEP() {

        AcessaWSTask task = new AcessaWSTask();
        try
        {
            String ret = task.execute("https://viacep.com.br/ws/"+etCEP.getText()+"/json/").get();

            Gson gson = new Gson();
            CEP cep = gson.fromJson(ret, CEP.class);

            // converte JSON para objeto
            etEndereco.setText(cep.getLogradouro());

            // converte Objeto para JSON
            // gson.toJson(ret);

        }
        catch(Exception ex)
        {
            etEndereco.setText(ex.getMessage());
        }

    }
}