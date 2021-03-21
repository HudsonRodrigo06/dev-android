package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.fipp.imccalculator.util.Calculos;

public class ResultadoActivity extends AppCompatActivity {

    private Button btVoltar;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btVoltar = findViewById(R.id.btVoltar);
        tvResult = findViewById(R.id.tvResult);

        exibeResultado();
        btVoltar.setOnClickListener( e-> { this.finish(); } );


    }

    private void exibeResultado() {
        double imc = getIntent().getDoubleExtra("imc", 0);
        String res = Calculos.getResultado(imc);

        tvResult.setText(res);
    }


}