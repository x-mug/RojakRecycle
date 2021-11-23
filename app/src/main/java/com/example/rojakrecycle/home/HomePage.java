package com.example.rojakrecycle.home;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.rojakrecycle.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomePage extends Fragment {

    private Button mStartButton;

    public CardView Card1;

    private PieChart pieChart;
    String[] materials = {"Glass", "Plastic", "Metal", "Paper", "E-waste"};
    int[] percentages = {30, 20, 15, 5, 30};

    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String TEXT = "text";


    boolean buttonsEnabled;
    Boolean enableAcess;
    String count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_home_page, null);


        //mStartButton = (Button) findViewById(R.id.btn_startQuiz);
        Card1 = (CardView) v.findViewById(R.id.card1);
        pieChart = v.findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();
        //setupChartView();

        Log.w("HomePage", String.valueOf(R.id.nav_host_fragment_activity_bottom_navigation));

        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new QuizActivity()).commit();
                //Intent intent = getIntent();
                //Bundle bundle = intent.getExtras();
                //int count = bundle.getInt("key");

                //validate(enableAcess);
            }
        });

        return v;
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

    public void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(20, "Glass"));
        entries.add(new PieEntry(20, "Plastic"));
        entries.add(new PieEntry(15, "Metal"));
        entries.add(new PieEntry(15, "Paper"));
        entries.add(new PieEntry(30, "E-waste"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color : ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color : ColorTemplate.VORDIPLOM_COLORS) {
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

//    private void CannotAcess() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomePage.this);
//        alertDialogBuilder
//                .setMessage("Daily Quiz is complete")
//                .setCancelable(false)
//                .setPositiveButton("Back to Homepage", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        startActivity(new Intent(getApplicationContext(), HomePage.class));
//
//                    }
//                });
//        alertDialogBuilder.show();
//    }
}