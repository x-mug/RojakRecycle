package com.example.rojakrecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class HomePage extends AppCompatActivity {

    private Button mStartButton;

    public CardView Card1;

    private PieChart pieChart;
    String[] materials = {"Glass", "Plastic", "Metal", "Paper", "E-waste"};
    int [] percentages = {30, 20, 15, 5, 30};

    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String TEXT = "text";


    boolean buttonsEnabled;
    Boolean enableAcess;
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //mStartButton = (Button) findViewById(R.id.btn_startQuiz);
        Card1 = (CardView) findViewById(R.id.card1);
        pieChart = findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();
        //setupChartView();


        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, QuizActivity.class);
                startActivity(intent);
                //Intent intent = getIntent();
                //Bundle bundle = intent.getExtras();
                //int count = bundle.getInt("key");

                //validate(enableAcess);
            }
        });
    }

    private void setupPieChart() {

        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("Collection");
        pieChart.setCenterTextSize(12);
        pieChart.getDescription().setEnabled(false);
        //pieChart.getLegend().setEnabled(false);
        //Description description = new Description();
        //description.setText("");
        //pieChart.setDescription(description);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    public void loadPieChartData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(20, "Glass"));
        entries.add(new PieEntry(20, "Plastic"));
        entries.add(new PieEntry(15, "Metal"));
        entries.add(new PieEntry(15, "Paper"));
        entries.add(new PieEntry(30, "E-waste"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        //data.setDrawValues(true);
        //data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        pieChart.getLegend().setEnabled(false);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    private void CannotAcess(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomePage.this);
        alertDialogBuilder
                .setMessage("Daily Quiz is complete")
                .setCancelable(false)
                .setPositiveButton("Back to Homepage", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), HomePage.class));

                    }
                });
        alertDialogBuilder.show();
    }
}