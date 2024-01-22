package com.example.divisass;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DivisaRVAdapter extends RecyclerView.Adapter<DivisaRVAdapter.MyViewHolder> {
    Context context;
    ArrayList<DivisaModel> divisaModels;
    private int itemSeleccionado = -1;
    private AdapterView.OnItemClickListener onItemClickListener;

    //constructor
    public DivisaRVAdapter(Context context, ArrayList<DivisaModel> divisaModel) {
        this.context = context;
        this.divisaModels = divisaModel;
    }



    // Crea y devuelve un ViewHolder
    @NonNull
    @Override
    public DivisaRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent,false);
        return  new DivisaRVAdapter.MyViewHolder(view);
    }

    @Override



    // Vincula los datos a las vistas en un elemento de la lista
    public void onBindViewHolder(@NonNull DivisaRVAdapter.MyViewHolder holder,  int position) {
        holder.tvName.setText(divisaModels.get(position).getDivisaName());
        holder.tvPrice.setText(divisaModels.get(position).getDivisaPrecio());
        holder.ivLogo.setImageDrawable(divisaModels.get(position).getDivisaLogo());

        // Cambia el color de fondo
        int backgroundColor = (position == itemSeleccionado) ? Color.parseColor("#FFCCCC") : Color.parseColor("#CCCCFF");
        holder.itemView.setBackgroundColor(backgroundColor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSeleccionado = position;
                notifyDataSetChanged();
                MainActivity.operacion = Double.parseDouble(holder.tvPrice.getText().toString());

                // Llama al método onItemClick si esta configurado
                if (onItemClickListener != null) {
                   //onItemClickListener.onItemClick(position);
                }
            }
        });




    }


    // Devuelve la cantidad de elementos en la lista
    @Override
    public int getItemCount() {
        return divisaModels.size();
    }

    public void setOnItemClickListener(DivisaRVAdapter.OnItemClickListener onItemClickListener) {
    }

    // MyViewHolder para contener las vistas de un elemento de la lista
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPrice;
        ImageView ivLogo;


        // Constructor del ViewHolder
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvDivisa);
            tvPrice = itemView.findViewById(R.id.tvPrecio);
            ivLogo = itemView.findViewById(R.id.logo_imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvPrice.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }


    public class OnItemClickListener {
    }
}
