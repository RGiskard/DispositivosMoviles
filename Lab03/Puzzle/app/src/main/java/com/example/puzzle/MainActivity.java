package com.example.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[][] nombres;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,execute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button)findViewById(R.id.primero);
        bt2 = (Button)findViewById(R.id.segundo);
        bt3 = (Button)findViewById(R.id.tercero);
        bt4 = (Button)findViewById(R.id.cuarto);
        bt5 = (Button)findViewById(R.id.quinto);
        bt6 = (Button)findViewById(R.id.sexto);
        bt7 = (Button)findViewById(R.id.setimo);
        bt8 = (Button)findViewById(R.id.octavo);
        bt9 = (Button)findViewById(R.id.noveno);
        nombres=new String[3][3];
        fillMatrix();
        execute = (Button)findViewById(R.id.ejecutar);
        //String buttonText = b.getText().toString();
        botones();

        execute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i=0;i<50;i++){
                    desordenar();
                    displayMatrix();
                }

            }
        });

    }
    public void fillMatrix()
    {
        nombres[0][0]=bt1.getText().toString();nombres[0][1]=bt2.getText().toString();nombres[0][2]=bt3.getText().toString();
        nombres[1][0]=bt4.getText().toString();nombres[1][1]=bt5.getText().toString();nombres[1][2]=bt6.getText().toString();
        nombres[2][0]=bt7.getText().toString();nombres[2][1]=bt8.getText().toString();nombres[2][2]=bt9.getText().toString();
    }
    public void botones()
    {
       /* bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!nombres[0][0].equals(""))
                    bt1.setText("@");
            }
        });*/
        bt9.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            if(nombres[2][2].equals("")) {
                int number = (int) (Math.random() * 2);
                String temp=nombres[1][2];
                nombres[1][2]=nombres[2][2];
                nombres[2][2]=temp;
                bt9.setText(nombres[2][2]);
                bt6.setText(nombres[1][2]);
            }
        }
    });
        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[1][2].equals("")) {
                    String temp=nombres[1][2];
                    nombres[1][2]=nombres[0][2];
                    nombres[0][2]=temp;
                    bt3.setText(nombres[0][2]);
                    bt6.setText(nombres[1][2]);
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[0][2].equals("")) {
                    String temp=nombres[0][1];
                    nombres[0][1]=nombres[0][2];
                    nombres[0][2]=temp;
                    bt3.setText(nombres[0][2]);
                    bt2.setText(nombres[0][1]);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[0][1].equals("")) {
                    String temp=nombres[0][1];
                    nombres[0][1]=nombres[0][0];
                    nombres[0][0]=temp;
                    bt1.setText(nombres[0][0]);
                    bt2.setText(nombres[0][1]);
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[0][0].equals("")) {
                    String temp=nombres[0][0];
                    nombres[0][0]=nombres[1][0];
                    nombres[1][0]=temp;
                    bt1.setText(nombres[0][0]);
                    bt4.setText(nombres[1][0]);
                }
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[1][0].equals("")) {
                    String temp=nombres[1][0];
                    nombres[1][0]=nombres[2][0];
                    nombres[2][0]=temp;
                    bt7.setText(nombres[2][0]);
                    bt4.setText(nombres[1][0]);
                }
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[2][0].equals("")) {
                    String temp=nombres[2][0];
                    nombres[2][0]=nombres[2][1];
                    nombres[2][1]=temp;
                    bt7.setText(nombres[2][0]);
                    bt8.setText(nombres[2][1]);
                }
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[2][1].equals("")) {
                    String temp=nombres[2][1];
                    nombres[2][1]=nombres[1][1];
                    nombres[1][1]=temp;
                    bt5.setText(nombres[1][1]);
                    bt8.setText(nombres[2][1]);
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(nombres[1][1].equals("")) {
                    String temp=nombres[1][1];
                    nombres[1][1]=nombres[0][1];
                    nombres[0][1]=temp;
                    bt5.setText(nombres[1][1]);
                    bt2.setText(nombres[0][1]);
                }
            }
        });

    }//ffunciones
    void displayMatrix()
    {
        bt1.setText(nombres[0][0]);bt2.setText(nombres[0][1]);bt3.setText(nombres[0][2]);
        bt4.setText(nombres[1][0]);bt5.setText(nombres[1][1]);bt6.setText(nombres[1][2]);
        bt7.setText(nombres[2][0]);bt9.setText(nombres[2][1]);bt9.setText(nombres[2][2]);
    }
    void desordenar()
    {
        Random aleatorio = new Random(System.currentTimeMillis());
        int intAletorio1 = aleatorio.nextInt(3);
        int intAletorio2 = aleatorio.nextInt(3);
        int intAletorio3 = aleatorio.nextInt(3);
        int intAletorio4 = aleatorio.nextInt(3);
        String temp=nombres[intAletorio1][intAletorio2];
        if(intAletorio1!=intAletorio3&&intAletorio2!=intAletorio4) {
            nombres[intAletorio1][intAletorio2] = nombres[intAletorio3][intAletorio4];
            nombres[intAletorio3][intAletorio4] = temp;
        }
    }


}
