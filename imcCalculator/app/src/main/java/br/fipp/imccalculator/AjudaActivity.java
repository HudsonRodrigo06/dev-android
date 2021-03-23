package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class AjudaActivity extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(e->{ this.finish(); });
    }
}