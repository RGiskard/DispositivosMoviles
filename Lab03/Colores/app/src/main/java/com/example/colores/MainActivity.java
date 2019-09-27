package com.example.colores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.graphics.Color;
public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupFondo;
    private RadioGroup radioGroupTexto;
    private RadioButton m_Radio1, m_Radio2, m_Radio3;
    private RadioButton m_Radio4, m_Radio5, m_Radio6;
    private CheckBox cbox;
    private int red = Color.parseColor("#FF0000");
    private int black = Color.parseColor("#000000");
    private int green = Color.parseColor("#629632");
    private int amarillo = Color.parseColor("#FFFF00");
    private int azul = Color.parseColor("#0000ff");
    private int blanco = Color.parseColor("#ffffff");


    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupFondo = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroupTexto = (RadioGroup) findViewById(R.id.radioGroup2);
        m_Radio1 = (RadioButton) findViewById(R.id.rbtNero);
        m_Radio2 = (RadioButton) findViewById(R.id.rbtRojo);
        m_Radio3 = (RadioButton) findViewById(R.id.rbtVerde);
        text = (TextView) findViewById(R.id.txtView);
        m_Radio4 = (RadioButton) findViewById(R.id.rbtTxtAmarillo);
        m_Radio5 = (RadioButton) findViewById(R.id.rbtTxtAzul);
        m_Radio6 = (RadioButton) findViewById(R.id.rbtTxtBlanco);
        cbox = (CheckBox) findViewById(R.id.cBoxtext);

        //Color red = Color.decode("#FF0000");

        radioGroupFondo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == m_Radio1.getId()) {
                    setActivityBackgroundColor(black);
                }
                if (checkedId == m_Radio2.getId()) {
                    setActivityBackgroundColor(red);
                }
                if (checkedId == m_Radio3.getId()) {
                    setActivityBackgroundColor(green);
                }
            }
        });

        radioGroupTexto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == m_Radio4.getId()) {
                    cambiarColorTexto(text, amarillo);
                }
                if (checkedId == m_Radio5.getId()) {
                    cambiarColorTexto(text, azul);
                }
                if (checkedId == m_Radio6.getId()) {
                    cambiarColorTexto(text, blanco);
                }
            }
        });

       cbox.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(text.getVisibility() != View.VISIBLE){ //si es Visible
                   text.setVisibility(View.VISIBLE);

               }else{ // si no es Visible
                   text.setVisibility(View.GONE);
               }
           }
       });

    }


   /* public void onRadioButtonClick(View v)
    {
        radioGroupFondo=(RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton radioBoton=findViewById(radioGroupFondo.getCheckedRadioButtonId());
        if(radioBoton==findViewById(R.id.rbtNero))
            Toast.makeText(this,"Funciona",Toast.LENGTH_LONG).show();
    }*/
   public void setActivityBackgroundColor(int color) {
       View view = this.getWindow().getDecorView();
       view.setBackgroundColor(color);
   }
   public void cambiarColorTexto(TextView txtver,int color)
   {
       txtver.setTextColor(color);
   }
}
