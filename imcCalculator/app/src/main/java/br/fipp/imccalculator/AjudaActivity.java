package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AjudaActivity extends AppCompatActivity {

    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        btVoltar = btVoltar.findViewById(R.id.btAjudaVoltar);
        btVoltar.setOnClickListener(e->{ this.finish(); });
    }
}