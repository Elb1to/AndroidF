/*package gg.rubit.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import gg.rubit.R;
import gg.rubit.data.Pairs;

public class WordPairsAdapter extends ArrayAdapter<Pairs> {

    private final List<Pairs> pairsList;

    public WordPairsAdapter(Context context, List<Pairs> datos) {
        super(context, R.layout.listviewpareo, datos);
        pairsList = datos;
    }

    public View getView(int position, View v, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        @SuppressLint({"ViewHolder", "InflateParams"})
        View item = inflater.inflate(R.layout.listviewpareo, null);

        TextView texto = (TextView) item.findViewById(R.id.lblPareoTemplate);
        //texto.setText(pairsList.get(position).getpre());

        TextView texto2 = (TextView) item.findViewById(R.id.lblPareores);
       // texto2.setText(pairsList.get(position).getres());

        return item;
    }
}*/
