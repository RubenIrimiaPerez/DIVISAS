package com.example.divisass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<DivisaModel> divisaModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.divisasRecycler);
        setDivisaModel();
        DivisaRVAdapter adapter = new DivisaRVAdapter(this,divisaModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setDivisaModel(){
        String[] NombreDivisa = getResources().getStringArray(R.array.DIVISAS_NAME);
        String[] PrecioDivisa = getResources().getStringArray(R.array.DIVISAS_PRECIO);

        for(int i = 0;i< NombreDivisa.length;i++){
            divisaModel.add(new DivisaModel(
                    NombreDivisa[i],
                    PrecioDivisa[i]

            ));
        }
    }





}



