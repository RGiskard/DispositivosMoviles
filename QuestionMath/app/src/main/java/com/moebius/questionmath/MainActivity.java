package com.moebius.questionmath;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
//import android.support.annotation.NonNull;
import androidx.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.mariuszgromada.math.mxparser.*;

import com.moebius.operadores.AnalizerAndCompute;
import com.moebius.operadores.AnalizerString;


import java.io.IOException;

/*Colores
* */
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    public static  final String EXTRA_STATEMENT="com.moebius.problem.EXTRA_STATEMENT";
    public static  final String EXTRA_SOLUTION="com.moebius.problem.EXTRA_SOLUTION";
    SurfaceView cameraView;
    TextView textView;
    CameraSource cameraSource;
    ImageButton imgbtcal;
    ImageButton imgbtfun;
    final int RequestCameraPermissionID = 1001;
    private int red = Color.parseColor("#FF0000");
    private int black = Color.parseColor("#000000");
    private int green = Color.parseColor("#629632");
    private int amarillo = Color.parseColor("#FFFF00");
    private int azul = Color.parseColor("#0000ff");
    private int blanco = Color.parseColor("#ffffff");


    public void openActivity()
    {
        Intent intent=new Intent(this,Calculator.class);
        startActivity(intent);
    }
    public void openActivityResults(String Problem,String sol)
    {
        Intent intent=new Intent(this,BoardResult.class);
        intent.putExtra(EXTRA_STATEMENT,Problem);
        intent.putExtra(EXTRA_SOLUTION,sol);
       // intent.putExtra(Solution)
        startActivity(intent);
    }
    public void computeFromCam()
    {
        ShuntingYard operador=new ShuntingYard();
        String test=(String.valueOf(textView.getText()));
        int a,b,c;
       // String expression = "(2^3-1)*sin(pi/4)/ln(pi^2)";
        //String expression = "1+1+1+1";
        // Evaluate an expression
        //Double result = evaluator.evaluate(test);
        AnalizerString as=new AnalizerString(test);
        //AnalizerAndCompute ac=new AnalizerAndCompute("solve( 2*x - 4, x, 0, 10 )");
        int flagOperator=as.discriminar();
        switch (flagOperator)
        {
            case 0:
                DoubleEvaluator evaluator = new DoubleEvaluator();
                Double result = evaluator.evaluate("(2^3-1)*sin(pi/4)/ln(pi^2)");
                openActivityResults(as.Statement(),"="+result);
                break;
            case 1:
                AnalizerAndCompute ac=new AnalizerAndCompute("solve( 2*x - 4, x, 0, 10 )");
                openActivityResults(as.Statement(),ac.Solution());
                break;
            case -1:
                textView.setText("Nada por hacer");
                break;
        }

        //textView.setText("El valor:"+test+" "+String.valueOf(result));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = (SurfaceView) findViewById(R.id.surface_view);
        textView = (TextView) findViewById(R.id.text_view);
        imgbtcal=(ImageButton)findViewById(R.id.imageButtonCalc);
        imgbtfun=(ImageButton)findViewById(R.id.imageButtonFun);
        //Inicio botón calculadora
        imgbtcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
        //Fin boton calculadora
        imgbtfun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeFromCam();
            }
        });
        //Inicio boton fun
        //Fin boton fun
        TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textRecognizer.isOperational()) {
            Log.w("MainActivity", "Las dependencias del detector aún no están disponibles");
        } else {

            cameraSource = new CameraSource.Builder(getApplicationContext(), textRecognizer)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {

                    try {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.CAMERA},
                                        RequestCameraPermissionID);
                             return;
                        }
                        cameraSource.start(cameraView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    cameraSource.stop();
                }
            });

            textRecognizer.setProcessor(new Detector.Processor< TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {

                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if(items.size() != 0)
                    {
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new StringBuilder();
                                for(int i =0;i<items.size();++i)
                                {
                                    TextBlock item = items.valueAt(i);
                                    stringBuilder.append(item.getValue());
                                    stringBuilder.append("\n");
                                }
                                textView.setText(stringBuilder.toString());
                                textView.setTextColor(red);
                            }
                        });
                    }
                }
            });
        }
    }
}
