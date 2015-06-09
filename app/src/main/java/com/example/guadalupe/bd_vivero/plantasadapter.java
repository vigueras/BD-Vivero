package com.example.guadalupe.bd_vivero;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class plantasadapter extends RecyclerView.Adapter<plantasadapter.plantaViewHolder> {
    private List<modeloPlantas> items;



    public static class plantaViewHolder extends RecyclerView.ViewHolder{

        public TextView id_plantas;
        public TextView nombre_plantas;
        public TextView tipo_plantas;
        public TextView color_plantas;
        public TextView precio;

        public plantaViewHolder(View v){
            super(v);
            id_plantas= (TextView) v.findViewById(R.id.id_plantass);
            nombre_plantas= (TextView) v.findViewById(R.id.nombre_plantass);
             tipo_plantas= (TextView) v.findViewById(R.id.tipo_plantaa);
            color_plantas= (TextView) v.findViewById(R.id.color_plantaass);
            precio= (TextView) v.findViewById(R.id.precioo);
        }
    }

    public plantasadapter(List<modeloPlantas> items){
        this.items= items;
    }

    @Override
    public plantaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.archivo_card, viewGroup, false);
        return new plantaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(plantaViewHolder plantaViewHolder, int i) {
        plantaViewHolder.id_plantas.setText("id de la planta: "+ String.valueOf(items.get(i).getId_plantas()));//solo a este por que es numerico, los demas ya son Strings
        plantaViewHolder.nombre_plantas.setText("nombre de la planta: "+ String.valueOf(items.get(i).getNombre_plantas()));
        plantaViewHolder.tipo_plantas.setText("tipo de planta: " + String.valueOf(items.get(i).getTipo_plantas()));
        plantaViewHolder.color_plantas.setText("color de la planta: " + String.valueOf(items.get(i).getColor_plantas()));
        plantaViewHolder.precio.setText("precio: "+ String.valueOf(items.get(i).getPrecio()));


    }

    @Override
    public int getItemCount() {

        return items.size();
    }
}
