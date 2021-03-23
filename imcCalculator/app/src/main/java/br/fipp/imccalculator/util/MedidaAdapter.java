package br.fipp.imccalculator.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import br.fipp.imccalculator.R;

//transforma arraylist em adapter
public class MedidaAdapter extends ArrayAdapter <Medida> {
    private int resource;
    public MedidaAdapter(@NonNull Context context, int resource, @NonNull List<Medida> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //instancia convertview
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resource, parent, false);
        }

        //liga componentes e pega dados
        TextView tvPeso = convertView.findViewById(R.id.tvPeso);
        TextView tvAltura = convertView.findViewById(R.id.tvAltura);
        TextView tvImc = convertView.findViewById(R.id.tvImc);
        TextView tvSituacao = convertView.findViewById(R.id.tvSituacao);

        Medida m = this.getItem(position); //pega objeto

        tvPeso.setText(""+m.getPeso());
        tvAltura.setText(""+m.getAltura());
        tvImc.setText(""+m.getImc());
        tvSituacao.setText(""+m.getCondicao());

        return convertView;
    }
}
