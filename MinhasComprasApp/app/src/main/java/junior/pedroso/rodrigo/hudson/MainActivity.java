package junior.pedroso.rodrigo.hudson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junior.pedroso.rodrigo.hudson.util.Carrinho;
import junior.pedroso.rodrigo.hudson.util.Compra;
import junior.pedroso.rodrigo.hudson.util.CompraAdapter;
import junior.pedroso.rodrigo.hudson.util.Singleton;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private Compra compra_long = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listview);

        // LER ARQUIVO SE EXISTIR
        FileInputStream fin  = null;
        ObjectInputStream in;
        try
        {
            fin = openFileInput("carrinho.dad");
            in = new ObjectInputStream(fin);
            Singleton.setCarrinho((Carrinho)in.readObject());
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
            Singleton.setCarrinho(new Carrinho());
        }



        CompraAdapter adapter = new CompraAdapter(this, R.layout.item_listview, Singleton.getCarrinho().getLista());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Grava position do item a ser editado em cookie
                /* COOKIES - GRAVAR DADOS */
                SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat("position", position);
                editor.commit();

                //Chama tela Novo Item
                Intent intent = new Intent(MainActivity.this, NovoActivity.class);
                startActivity(intent);

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //desativar
                if(lista.getChildAt(position).isEnabled())
                {
                    //remove da lista
                    compra_long = Singleton.getCarrinho().getLista().get(position);
                    Singleton.getCarrinho().getLista().remove(position);

                    //muda cor de fundo "desmarca"
                    lista.getChildAt(position).setBackgroundColor(Color.rgb(227, 200, 230));
                    lista.getChildAt(position).setEnabled(false);
                }
                //ativar
                else
                {
                    Singleton.getCarrinho().getLista().add(compra_long);

                    lista.getChildAt(position).setBackgroundColor(Color.rgb(200, 230, 201));
                    lista.getChildAt(position).setEnabled(true);
                }

                //lista.deferNotifyDataSetChanged();
                //((CompraAdapter)lista.getAdapter()).notifyDataSetChanged();

                return false;
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();

        // GRAVAR OBJETOS NO ARQUIVO AO PAUSAR

        FileOutputStream fout  = null;
        ObjectOutputStream out;
        try
        {
            fout = openFileOutput("carrinho.dad", Context.MODE_PRIVATE);
            out = new ObjectOutputStream(fout);
            out.writeObject(Singleton.getCarrinho());
            out.close();
        }
        catch(Exception e){   e.printStackTrace();}
    }

    @Override
    protected void onResume() {
        super.onResume();

        ((CompraAdapter)lista.getAdapter()).notifyDataSetChanged();
    }

    /* MENU */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /* NECESSARIO "INFLAR" O MENU */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // chamar activity ajuda
        if (item.getItemId() == R.id.itNovo) {
            Intent intent = new Intent(this, NovoActivity.class);
            startActivity(intent);
        }
        else {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
    /* MENU */
}