package br.fipp.imccalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import br.fipp.imccalculator.util.Calculos;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbPeso, sbAltura;
    private TextView tvResultado, tvPeso, tvAltura;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbPeso = findViewById(R.id.sbPeso);
        sbAltura = findViewById(R.id.sbAltura);
        tvResultado = findViewById(R.id.tvResultado);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);

        tvResultado.setOnClickListener( e->{ exibeResultado(); });

        sbPeso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPeso.setText(""+(progress+1));
                calcImc();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        sbAltura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAltura.setText(""+(progress/100.0));
                calcImc();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }

    /* MENU */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /* NECESSARIO "INFLAR" O MENU */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itAjuda){
            // chamar activity ajuda
            Intent intent = new Intent(this, AjudaActivity.class);
            startActivity(intent);
        }
        else{
            this.finish();
        }

        return true;
    }
    /* MENU */

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
            double peso = sbPeso.getProgress()+1;
            double altura = sbAltura.getProgress()/100.0;
            DecimalFormat df = new DecimalFormat("###.00");



            double imc = Calculos.IMC(peso, altura);
            tvResultado.setText(df.format(imc));
        }
        catch(Exception ex){
            Toast.makeText(this, "Erro de entrada de dados: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}