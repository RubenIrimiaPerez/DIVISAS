package com.example.divisass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

    //variable para guardar el valor de la divisa seleccionada
    public static  double operacion;
    ArrayList<DivisaModel> divisaModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración del RecyclerView y su adaptador
        RecyclerView recyclerView = findViewById(R.id.divisasRecycler);
        setDivisaModel();
        DivisaRVAdapter adapter = new DivisaRVAdapter(this,divisaModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //variable usada para cobrar un 2% a los usuarios no vip
        double NoVip = 0.98;

        // Elementos de la interfaz activity_main.xml
        TextView resultado = findViewById(R.id.resultado);
        EditText euros = findViewById(R.id.euros);
        Switch vip = findViewById(R.id.vipSwitch);
        Button convertir = findViewById(R.id.convertir);

        //accion del boton convertir
        convertir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 //funcion del boton switch
                if (vip.isChecked()) {
                    resultado.setText(operacion * Double.parseDouble(euros.getText().toString())+"");
                } else {
                    resultado.setText(operacion * NoVip * Double.parseDouble(euros.getText().toString()) + "");
                }


            }
        });
    }

    private void setDivisaModel(){

        // Obtener los datos de los tres arrays.
        String[] NombreDivisa = getResources().getStringArray(R.array.DIVISAS_NAME);
        String[] PrecioDivisa = getResources().getStringArray(R.array.DIVISAS_PRECIO);

        TypedArray typeArray = getResources().obtainTypedArray(R.array.DIVISAS_LOGO);
        Drawable[] LogoDivisa = new Drawable[typeArray.length()];


        // for para obtener las banderas
        for (int i = 0; i < typeArray.length(); i++) {
            int id = typeArray.getResourceId(i, 0);
            if (id != 0) {
                LogoDivisa[i] = ContextCompat.getDrawable(this, id);
            }
        }
        typeArray.recycle();
        // Creación del array entero
        for(int i = 0;i< NombreDivisa.length;i++){
            divisaModel.add(new DivisaModel(
                    NombreDivisa[i],
                    PrecioDivisa[i],
                    LogoDivisa[i]


            ));
        }
    }


    }









