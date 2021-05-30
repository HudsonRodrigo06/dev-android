package junior.pedroso.rodrigo.appgetrandomuser;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.gson.Gson;

import junior.pedroso.rodrigo.appgetrandomuser.gson_class.Random;
import junior.pedroso.rodrigo.appgetrandomuser.gson_class.User;
import junior.pedroso.rodrigo.appgetrandomuser.util.AcessaWSTask;
import junior.pedroso.rodrigo.appgetrandomuser.util.BaixaImagem;
import junior.pedroso.rodrigo.appgetrandomuser.util.Filtro;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMale;
    private RadioButton rbFemale;
    private EditText etLocalidade;
    private Button btBuscar;

    private ImageView imageView;
    private EditText etRes;

    private Filtro filtro = new Filtro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        etLocalidade = findViewById(R.id.etLocalidade);
        btBuscar = findViewById(R.id.btBuscar);

        imageView = findViewById(R.id.imageView);
        etRes = findViewById(R.id.etRes);

        carregaInfo();

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaInfo();
            }
        });

        rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    filtro.setGenero("female");
            }
        });

        rbMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    filtro.setGenero("male");
            }
        });

    }



    private void carregaInfo() {
        AcessaWSTask task = new AcessaWSTask();
        String sJson = "Erro ao processar a informação";

        String genero, nacionalidade, url;

        //alimenta strings
        genero = filtro.getGenero();
        url = "https://randomuser.me/api/0.7?gender="+genero;

        nacionalidade = etLocalidade.getText().toString();
        if(!nacionalidade.isEmpty())
            url += "&nationality="+nacionalidade.toUpperCase();

        try {
            sJson = task.execute(url).get();

            // GSON
            Gson gson = new Gson();
            Random rand = gson.fromJson(sJson, Random.class);
            User us = rand.results.get(0).user;

            //alimenta descrição
            etRes.setText(us.getName().getFirst() + " " + us.getName().getLast() +
                    ", " + us.getGender() +
                    ", " + rand.getNationality());

            // recuperar url foto
            String fotourl = us.picture.large;

            // renderizar foto
            BaixaImagem bimg = new BaixaImagem();
            Bitmap bmp = bimg.execute(fotourl).get();

            imageView.setImageBitmap(bmp);
        }
        catch (Exception ex){
            sJson = ex.getMessage();
        }


    }

}