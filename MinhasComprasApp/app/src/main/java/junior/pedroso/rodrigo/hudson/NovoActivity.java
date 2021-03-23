package junior.pedroso.rodrigo.hudson;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import junior.pedroso.rodrigo.hudson.util.Compra;
import junior.pedroso.rodrigo.hudson.util.CompraAdapter;
import junior.pedroso.rodrigo.hudson.util.Singleton;

public class NovoActivity extends AppCompatActivity {

    private int item_pos;
    private Compra item_alterar = null;

    private EditText etItem;
    private SeekBar sbQtde;
    private Spinner spinUn;
    private TextView tvQtde;
    private Button btConfirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        //ligarComponentes();
        etItem = findViewById(R.id.etItem);
        sbQtde = findViewById(R.id.sbQtde);
        spinUn = findViewById(R.id.spinUn);
        tvQtde = findViewById(R.id.tvQtde);
        btConfirmar = findViewById(R.id.btConfirmar);

        alimentarSpinner();

        //editar
        try{
            item_pos = getItemPosition();
            item_alterar = Singleton.getCarrinho().getLista().get(item_pos);

            etItem.setText(item_alterar.getItem());
            sbQtde.setProgress(item_alterar.getQtde());
            //spinUn.set???
            tvQtde.setText(item_alterar.getQtde()+"");

            Toast.makeText(this, "Editar Item", Toast.LENGTH_SHORT).show();

        }catch(Exception ex){
            Toast.makeText(this, "Novo Item", Toast.LENGTH_SHORT).show();
        }


        //EVT CHANGE SPINNER ??
        /*
        spinUn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if(spinUn.getSelectedItem() == "Centimetro" ||
                            spinUn.getSelectedItem() == "Mililitro" ||
                            spinUn.getSelectedItem() == "Gramas"){

                        sbQtde.setMax(1000);
                    }
                    else
                        sbQtde.setMax(20);
            }
        });  */


        // EVT SEEKBAR
        sbQtde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvQtde.setText(""+(progress)); // +1?
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        //EVT CONFIRMAR
        btConfirmar.setOnClickListener(e->{

            Compra novo = new Compra();

            novo.setItem(etItem.getText().toString());
            novo.setQtde(Integer.parseInt(tvQtde.getText().toString()));
            novo.setUn_medida(spinUn.getSelectedItem().toString());

            Singleton.getCarrinho().addCompra(novo);

            Toast.makeText(this, "Item Adicionado", Toast.LENGTH_SHORT).show();

            this.finish();


        });
    }



    private void alimentarSpinner(){

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.medidas,
                        android.R.layout.simple_spinner_item);
        spinUn.setAdapter(adapter);
    }

    private int getItemPosition(){

        //Retorna position do item a ser carregado na tela para alterar

        /* COOKIES - LER DADOS */

        SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
        return prefs.getInt("position", 0);

    }
}