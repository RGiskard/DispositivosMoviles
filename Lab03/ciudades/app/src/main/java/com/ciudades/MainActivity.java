package com.ciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Spinner ciudades, paises;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paises = (Spinner)findViewById(R.id.paises);
        ciudades = (Spinner)findViewById(R.id.ciudades);
        texto = (TextView)findViewById(R.id.texto);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
                this, R.array.paises, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paises.setAdapter(adaptador);
        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource(
                this, R.array.ciudadesespana, android.R.layout.simple_spinner_item);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adaptador2);

        paises.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                int opciones = R.array.ciudadesespana;

                switch(arg2) {
                    case 0:
                        opciones = R.array.ciudadesespana;
                        break;
                    case 1:
                        opciones = R.array.ciudadesalemania;
                        break;
                    case 2:
                        opciones = R.array.ciudadesfrancia;
                        break;
                }

                ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
                        MainActivity.this, opciones, android.R.layout.simple_spinner_item);
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ciudades.setAdapter(adaptador);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        ciudades.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                texto.setText(ciudades.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


    }

}
