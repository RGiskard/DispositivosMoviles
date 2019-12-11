package com.google.firebase.codelab.mlkit;
import java.text.DecimalFormat;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class BoardResult extends AppCompatActivity {
    TextView textView;
    Button btSteps;
    TextView textViewSol;
    GraphView graphView;
    LineGraphSeries< DataPoint > series;
    DecimalFormat df2 = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_result);
        Intent intent=getIntent();
        String problem=intent.getStringExtra(MainActivity.EXTRA_STATEMENT);
        String solution=intent.getStringExtra(MainActivity.EXTRA_SOLUTION);
        String expresion=intent.getStringExtra(MainActivity.EXTRA_Expr);
        textView=(TextView)findViewById(R.id.txtProblem);
        textViewSol=(TextView)findViewById(R.id.txtSolution);
        btSteps=(Button)findViewById(R.id.btBySteps);
        textView.setText(problem);
        textViewSol.setText(solution);
        graphView=(GraphView)findViewById(R.id.graph);
        double x,y;

        //String expresion="2*x-4";
        x=-10.0;
        series=new LineGraphSeries<DataPoint>();
        for(int i=0;i<500;i++)
        {
            x+=0.1;
            DoubleEvaluator evaluator = new DoubleEvaluator();
            String newEval=expresion;
            //newEval=newEval.replaceAll("x",String.valueOf(x));
            newEval=newEval.replaceAll("x",df2.format(x));
            y=evaluator.evaluate(newEval).floatValue();
            //y=2*x-4;
            //Log.i("El eval:",String.valueOf(evaluator.evaluate(newEval).floatValue()));
            series.appendData(new DataPoint(x,y),true,500);
        }
        graphView.addSeries(series);
    }
}
