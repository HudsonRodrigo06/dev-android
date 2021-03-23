package br.fipp.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import br.fipp.imccalculator.util.Medida;
import br.fipp.imccalculator.util.MedidaAdapter;
import br.fipp.imccalculator.util.Singleton;

public class ListActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = findViewById(R.id.listview);
//        ArrayAdapter<Medida> adapter;
//
//        adapter = new ArrayAdapter<Medida>(this, android.R.layout.simple_list_item_1, Singleton.getMedidas());
        MedidaAdapter adapter = new MedidaAdapter(this, R.layout.item_listview, Singleton.getMedidas());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, Singleton.getMedidas().get(position).getCondicao(), Toast.LENGTH_LONG).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Singleton.getMedidas().remove(position);
                //lista.deferNotifyDataSetChanged();
                ((MedidaAdapter)lista.getAdapter()).notifyDataSetChanged();
                return false;
            }
        });
    }
}