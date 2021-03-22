package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.fipp.imccalculator.util.Medida;
import br.fipp.imccalculator.util.Singleton;

public class ListActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = findViewById(R.id.listview);
        ArrayAdapter<Medida> adapter;

        adapter = new ArrayAdapter<Medida>(this, android.R.layout.simple_list_item_1, Singleton.getMedidas());
        lista.setAdapter(adapter);
    }
}