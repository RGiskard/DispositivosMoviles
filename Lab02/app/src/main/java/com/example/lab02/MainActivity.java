package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton boton1=(ImageButton) findViewById(R.id.imgbt1);
        boton1.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Ciencia Ficción",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton2=(ImageButton) findViewById(R.id.imgbt2);
        boton2.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Literatura Fantástica",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton3=(ImageButton) findViewById(R.id.imgbt3);
        boton3.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Ficción Gótica",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

        ImageButton boton4=(ImageButton) findViewById(R.id.imgbt4);
        boton4.setOnClickListener(new View.OnClickListener(){

                                      @Override
                                      public void onClick(View view) {
                                          Toast notificar=Toast.makeText(MainActivity.this,"Cuentos de Hadas",Toast.LENGTH_LONG);
                                          notificar.show();
                                          Intent intento=new Intent(getApplicationContext(),SlideBookActivity.class);
                                          startActivity(intento);
                                      }
                                  }

        );

    }


    @Override
    public void onClick(View view) {

    }
}
