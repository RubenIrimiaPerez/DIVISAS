package com.example.divisass;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
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


    public DivisaRVAdapter(Context context, ArrayList<DivisaModel> divisaModel) {
        this.context = context;
        this.divisaModels = divisaModel;
    }

    @NonNull
    @Override
    public DivisaRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cv_row, parent,false);
        return  new DivisaRVAdapter.MyViewHolder(view);
    }

    @Override


    public void onBindViewHolder(@NonNull DivisaRVAdapter.MyViewHolder holder,  int position) {
        holder.tvName.setText(divisaModels.get(position).getDivisaName());
        holder.tvPrice.setText(divisaModels.get(position).getDivisaPrecio());


        int backgroundColor = (position == itemSeleccionado) ? Color.parseColor("#e7bfcb") : Color.WHITE;
        holder.itemView.setBackgroundColor(backgroundColor);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSeleccionado = position;
                notifyDataSetChanged();
                if (onItemClickListener != null) {
                   //onItemClickListener.onItemClick(position);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return divisaModels.size();
    }

    public void setOnItemClickListener(DivisaRVAdapter.OnItemClickListener onItemClickListener) {
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvDivisa);
            tvPrice = itemView.findViewById(R.id.tvPrecio);
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
