package com.example.rojakrecycle.home;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.rojakrecycle.R;
import com.example.rojakrecycle.UserData.UserData;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomePage extends Fragment {


    public CardView Card1;

    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_home_page, null);


        Card1 = (CardView) v.findViewById(R.id.card1);
        pieChart = v.findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();


        Log.w("HomePage", String.valueOf(R.id.nav_host_fragment_activity_bottom_navigation));

        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                if (UserData.GetInstance().GetTimeStamp().equals(date)) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder
                            .setMessage("Daily Quiz is complete" +
                                    "\nCome back tomorrow to get more points!")
                            .setCancelable(false)
                            .setPositiveButton("Back to Homepage", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new NoQuizActivity()).commit();
                                    //startActivity(new Intent(getApplicationContext(), NoQuizActivity.class));

                                }
                            });
                    alertDialogBuilder.show();
                    return;
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new QuizActivity()).commit();

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

        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        pieChart.getLegend().setEnabled(false);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

}