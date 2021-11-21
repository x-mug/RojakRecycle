package com.example.rojakrecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
//import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
//import android.widget.CompoundButton;
//import android.widget.EditText;
//import android.widget.Switch;
import android.widget.TextView;
//import android.widget.Toast;

public class ResultActivity extends AppCompatDialogFragment {

    private TextView tv_outOf;
    private TextView tv_ques;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_result, null);

        tv_outOf = view.findViewById(R.id.tv_outOf);
        tv_ques = view.findViewById(R.id.tv_ques);


        if(getArguments() != null){
            int score = getArguments().getInt("finalScore");

            tv_outOf.setText("You scored " + score + " out of " + QuizBook.images.length);

        }




        builder.setView(view)
                .setPositiveButton("Back to Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getActivity(), HomePage.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}