package junior.pedroso.rodrigo.hudson.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import junior.pedroso.rodrigo.hudson.R;

public class CompraAdapter extends ArrayAdapter<Compra> {

    private int resource;
    public CompraAdapter(@NonNull Context context, int resource, @NonNull List<Compra> objects) {
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

        TextView tvQtde = convertView.findViewById(R.id.tvQtde);
        TextView tvUn = convertView.findViewById(R.id.tvItem);
        TextView tvItem = convertView.findViewById(R.id.tvItem);

        Compra c = this.getItem(position);

        tvQtde.setText(c.getQtde()+"");
        tvUn.setText(c.getUn_medida());
        tvItem.setText(c.getItem());



        return convertView;
    }
}
