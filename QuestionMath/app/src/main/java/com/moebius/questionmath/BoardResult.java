package com.moebius.questionmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BoardResult extends AppCompatActivity {
    TextView textView;
    Button btSteps;
    TextView textViewSol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_result);
        Intent intent=getIntent();
        String problem=intent.getStringExtra(MainActivity.EXTRA_STATEMENT);
        String solution=intent.getStringExtra(MainActivity.EXTRA_SOLUTION);
        textView=(TextView)findViewById(R.id.txtProblem);
        textViewSol=(TextView)findViewById(R.id.txtSolution);
        btSteps=(Button)findViewById(R.id.btBySteps);
        textView.setText(problem);
        textViewSol.setText(solution);
    }
}
