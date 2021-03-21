package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso, etAltura;
    private Button btCalcular;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Linka objetos da interafce */
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btCalcular = findViewById(R.id.btCalcular);
        tvResultado = findViewById(R.id.tvResultado);


        /* EVENTOS */

        /*
            btCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvResultado.setText("30");
                }
            });
        */
        btCalcular.setOnClickListener( e->{ calcImc(); });

    }

    private void calcImc() {
        double peso = Double.parseDouble(String.valueOf(etPeso.getText()));
        double altura = Double.parseDouble(String.valueOf(etAltura.getText()));
        double imc = peso/(altura*altura);
        DecimalFormat df = new DecimalFormat("###.00");
        String res = "";

        if(imc < 18.6)
            res = "MAGREZA";
        else if(imc < 25)
            res = "NORMAL";
        else if(imc < 30)
            res = "SOBREPESO";
        else if (imc < 40)
            res = "OBESIDADE GRAU II";
        else
            res = "OBESIDADE GRAVE";


        tvResultado.setText(df.format(imc) + " " + res);
    }
}