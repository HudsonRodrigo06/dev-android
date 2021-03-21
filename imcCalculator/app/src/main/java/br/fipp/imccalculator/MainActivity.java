package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import br.fipp.imccalculator.util.Calculos;

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
            SE TEM 1 PARAMETRO, USA O  e->{} ..... SE NAO TEM PARAMETRO, USA ()->{}
            SE TEM 2 USA (e, f) -> {}

            btCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvResultado.setText("30");
                }
            });
        */

        btCalcular.setOnClickListener( e->{ calcImc(); });
        tvResultado.setOnClickListener( e->{ exibeResultado(); });

    }

    private void exibeResultado() {
        // INTENÇÃO DE TROCAR DE TELA ...          Contexto atual, Activity futura
        Intent intent = new Intent(this, ResultadoActivity.class);

        //envia dados para outra activity (chave, valor)
        intent.putExtra("imc", Double.parseDouble(tvResultado.getText().toString().replace(",", ".")));

        startActivity(intent);
    }


    private void calcImc() {

        try
        {
            double peso = Double.parseDouble(etPeso.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString());
            DecimalFormat df = new DecimalFormat("###.00");

            if(altura == 0 || peso == 0)
                throw new Exception("Valor Zero.");

            double imc = Calculos.IMC(peso, altura);
            tvResultado.setText(df.format(imc));
        }
        catch(Exception ex){
            Toast.makeText(this, "Erro de entrada de dados: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}