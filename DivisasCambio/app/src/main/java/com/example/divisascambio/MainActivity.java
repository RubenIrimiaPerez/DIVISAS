package com.example.divisascambio;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText amountEditText;
    private RecyclerView recyclerView;
    private Button convertButton;
    private TextView resultTextView;
    private Switch vipSwitch;

    private List<String> Nombre;
    private List<String> NombrePrec;
    private List<Double> precio;

    private int selectedCurrencyPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amountEditText);
        recyclerView = findViewById(R.id.recyclerView);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);
        vipSwitch = findViewById(R.id.vipSwitch);

        initCurrencyData();
        initRecyclerView();

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });
    }

    private void initCurrencyData() {
        Nombre = new ArrayList<>();
        Nombre.add("USD");
        Nombre.add("GPB");
        Nombre.add("JPY");
        Nombre.add("CNY");
        Nombre.add("CAD");
        Nombre.add("ALL");
        Nombre.add("BAM");
        Nombre.add("ARS");
        Nombre.add("DKK");
        Nombre.add("LBP");

        NombrePrec = new ArrayList<>();
        NombrePrec.add("         USD       =    1.08697 $");
        NombrePrec.add("         GPB       =    0.85881 £");
        NombrePrec.add("         JPY       =    160.716 ¥");
        NombrePrec.add("         CNY       =    7.74205 ¥");
        NombrePrec.add("         CAD       =    1.46866 $");
        NombrePrec.add("         ALL       =    101.743 L");
        NombrePrec.add("         BAM       =    1.95583 KM");
        NombrePrec.add("         ARS       =    889.535 $");
        NombrePrec.add("         DKK       =    7.45761 kr");
        NombrePrec.add("         LBP       =    16304.5 ل.ل");


        precio = new ArrayList<>();
        precio.add(1.08697); // Exchange rate for AUD
        precio.add(0.85881); // Exchange rate for USD
        precio.add(160.716);
        precio.add(7.74205);
        precio.add(1.46866);
        precio.add(101.743);
        precio.add(1.95583);
        precio.add(889.535);
        precio.add(7.45761);
        precio.add(16304.5);

    }

    private void initRecyclerView() {
        CurrencyAdapter adapter = new CurrencyAdapter(NombrePrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CurrencyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                handleCurrencySelection(position);
            }
        });
    }

    private void handleCurrencySelection(int position) {
        selectedCurrencyPosition = position;
    }

    private void convertCurrency() {
        double amount = Double.parseDouble(amountEditText.getText().toString());
        double exchangeRate = precio.get(selectedCurrencyPosition);

        if (vipSwitch.isChecked()) {
            exchangeRate *= 1;
        }else{
            exchangeRate *= 0.98;
        }

        double result = amount * exchangeRate;
        resultTextView.setText(String.format("%.2f %s", result, Nombre.get(selectedCurrencyPosition)));
    }
}