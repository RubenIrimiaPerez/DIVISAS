package com.example.divisascambio;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {

    private List<String> currencies;
    private OnItemClickListener onItemClickListener;
    private int selectedPosition = RecyclerView.NO_POSITION;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public CurrencyAdapter(List<String> currencies) {
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_currency, parent, false);
        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, final int position) {
        holder.currencyTextView.setText(currencies.get(position));


                holder.itemView.setBackgroundColor(selectedPosition == position ?
                ContextCompat.getColor(holder.itemView.getContext(), R.color.selectedColor) :
                Color.TRANSPARENT);
                 holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    handleSelection(position);
                    onItemClickListener.onItemClick(position);
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }
    private void handleSelection(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    public static class CurrencyViewHolder extends RecyclerView.ViewHolder {
        public TextView currencyTextView;

        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyTextView = itemView.findViewById(R.id.textCurrency);
        }
    }
}
