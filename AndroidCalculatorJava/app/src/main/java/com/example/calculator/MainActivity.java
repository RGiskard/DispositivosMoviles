package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    TextView  display;
    CharSequence antes;
    String expresion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bt0(View view){
        display=(TextView)findViewById(R.id.editText);
        String init=String.valueOf(display.getText());
        if(init.length()==1&&init.equals("0"))
            display.setText(display.getText()+"0");
        else
        {

            display.setText(display.getText()+"0");
        }


    }
    public void bt1(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"1");

    }
    public void bt2(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"2");

    }
    public void bt3(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"3");

    }
    public void bt4(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"4");

    }
    public void bt5(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"5");

    }
    public void bt6(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"6");

    }
    public void bt7(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"7");

    }
    public void bt8(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"8");

    }
    public void bt9(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"9");

    }
    public void btclear(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText("");
    }
    public void btplus(View view){
        display=(TextView)findViewById(R.id.editText);
        String temp=String.valueOf(display.getText());
        display.setText(display.getText()+"+");

        if(temp.length()==0)
            display.setText("");
        else
        {
            char key=temp.charAt(temp.length()-1);
            if (key=='-'||key=='*'||key=='/'||key=='+')
                temp = temp.substring(0,temp.length() - 1);
            display.setText(temp+"+");
        }


    }
    public void btminus(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        String temp=String.valueOf(display.getText());
        display.setText(display.getText()+"-");
        if(temp.length()==0)
            display.setText("");
        else
        {
            char key=temp.charAt(temp.length()-1);
            if (key=='-'||key=='*'||key=='/'||key=='+')
                temp = temp.substring(0,temp.length() - 1);
            display.setText(temp+"-");
        }
    }
    public void btdot(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+")");
    }


    public void btplusMinus(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        display.setText(display.getText()+"(");
    }
    public void btpor(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        String temp=String.valueOf(display.getText());
        display.setText(display.getText()+"*");
        if(temp.length()==0)
            display.setText("");
        else
        {
            char key=temp.charAt(temp.length()-1);
            if (key=='-'||key=='*'||key=='/'||key=='+')
                temp = temp.substring(0,temp.length() - 1);
            display.setText(temp+"*");
        }
    }
    public void bback(View view){
        display=(TextView)findViewById(R.id.editText);
        String cadena=String.valueOf(display.getText());
        if(!cadena.isEmpty())
            cadena=cadena.substring(0, cadena.length() - 1);
        display.setText(cadena);
    }
    public void btdiv(View view){
        display=(TextView)findViewById(R.id.editText);
        antes=display.getText();
        String temp=String.valueOf(display.getText());
        display.setText(display.getText()+"/");
        if(temp.length()==0)
            display.setText("");
        else
        {
            char key=temp.charAt(temp.length()-1);
            if (key=='-'||key=='*'||key=='/'||key=='+')
                temp = temp.substring(0,temp.length() - 1);
            display.setText(temp+"/");
        }
    }
    public void btigual(View view)
    {
        display=(TextView)findViewById(R.id.editText);
        //String test="3+4*2/(1-5)^2^3";
        String test=(String.valueOf(display.getText()));
       // String postfix=ShuntingYard::infixToPostfix(test);
       if(!test.isEmpty()) {
           ShuntingYard ST = new ShuntingYard();
           String val = ST.shuntingYard(test);
           val = val.replace(" ", "");
           val = ST.evaluatePostfix(val);
           String textFInal=test+"="+val;
           display.setText(textFInal);
       }
       else
           display.setText("");
    }
}
