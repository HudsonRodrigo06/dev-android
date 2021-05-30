package junior.pedroso.rodrigo.appfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junior.pedroso.rodrigo.appfragments.fragments.OneFragment;
import junior.pedroso.rodrigo.appfragments.fragments.TwoFragment;
import junior.pedroso.rodrigo.appfragments.gson_class.User;
import junior.pedroso.rodrigo.appfragments.util.AcessaWSTask;

import junior.pedroso.rodrigo.appfragments.gson_class.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvNome;
    private Button bt1, bt2;
    private FragmentManager fm;
    private OneFragment oneFrag = new OneFragment();
    private TwoFragment twoFrag = new TwoFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNome = findViewById(R.id.tvNome);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        fm = getSupportFragmentManager();


        //carrega quando entra
        carregaInfo();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // substitui area do fragmento para o primeiro
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment , oneFrag);
                ft.commit();
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // substitui area do fragmento para o segundo
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment , twoFrag);
                ft.commit();
            }
        });

    }

    private void carregaInfo() {
        AcessaWSTask task = new AcessaWSTask();
        String sJson = "Erro ao processar a informação";

        try {
            sJson = task.execute("https://randomuser.me/api/0.7").get();

            // GSON
            Gson gson = new Gson();
            Random rand = gson.fromJson(sJson, Random.class);
            User us = rand.getResults().get(0).getUser();

            //alimenta nome
            tvNome.setText(us.getName().getFirst() + " " + us.getName().getLast());


        }
        catch (Exception ex){
            sJson = ex.getMessage();
        }
    }
}