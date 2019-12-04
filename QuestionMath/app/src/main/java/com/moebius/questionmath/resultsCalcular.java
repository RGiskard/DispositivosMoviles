package com.moebius.questionmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class resultsCalcular extends AppCompatActivity {
    TextView tvExpresion;
    TextView tvResultado;
    Button btStepByStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String problem=intent.getStringExtra(MainActivity.EXTRA_STATEMENT_CALC);
        String solution=intent.getStringExtra(MainActivity.EXTRA_SOLUTION_CALC);
        setContentView(R.layout.activity_results_calcular);
        tvExpresion=(TextView)findViewById(R.id.txtProblemCalc);
        tvResultado=(TextView)findViewById(R.id.txtSolutionCalc);
        btStepByStep=(Button) findViewById(R.id.btByStepsCalc);
        tvExpresion.setText(problem);
        tvResultado.setText(solution);
    }
}
