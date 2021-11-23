package com.example.rojakrecycle.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rojakrecycle.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class QuizActivity extends Fragment {

    private TextView tv_score;
    private ImageView QuestionImage;
    private Button trueBtn, falseBtn;

    private boolean Answer;
    private int points = 0;
    private int QuestionNumber = 0;
    private int previousPoints = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = View.inflate(getActivity(), R.layout.activity_quiz, null);

        tv_score = (TextView) v.findViewById(R.id.points);
        QuestionImage = (ImageView) v.findViewById(R.id.iv_ques1);
        trueBtn = (Button) v.findViewById(R.id.btn_true);
        falseBtn = (Button) v.findViewById(R.id.btn_false);

        updateQuestion();

        FirebaseDatabase
                .getInstance()
                .getReference()
                .child("users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("RojakPoint")
                .get()
                .addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            previousPoints = Integer.parseInt(task.getResult().getValue().toString());
                        }
                    }
                });

        //Logic for True Button
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences sharedPreferences = getSharedPreferences(QuizActivity.PREFS_NAME,0);
                //SharedPreferences.Editor editor = sharedPreferences.edit();

                //editor.putBoolean("hasLoggedIn", true);
                //editor.commit();

                if (Answer == true) {
                    Toast.makeText(getActivity(), "You are correct", Toast.LENGTH_SHORT).show();
                    points = points + 1; //This update the score int variables
                    updateScore(points); //This convert the int variables to a String and adds it to score

                    //Perform this check before you update the question
                    if (QuestionNumber == QuizBook.images.length) {
                        GameFinish();
                        //Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putInt("finalScore", points);
                        //i.putExtras(bundle);
                        //QuizActivity.this.finish();
                        //startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                //if the question is wrong
                else {
                    if (QuestionNumber == QuizBook.images.length) {
                        GameFinish();
                        //Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putInt("finalScore", points);
                        //i.putExtras(bundle);
                        //QuizActivity.this.finish();
                        //startActivity(i);
                    } else {
                        updateQuestion();
                    }

                }
            }
        });

        //Logic for false Button
        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Answer == false) {
                    Toast.makeText(getActivity(), "You are correct", Toast.LENGTH_SHORT).show();
                    points++; //This update the score int variables
                    updateScore(points); //This convert the int variables to a String and adds it to score

                    //Perform this check before you update the question
                    if (QuestionNumber == QuizBook.images.length) {
                        GameFinish();

                    } else {
                        updateQuestion();
                    }
                }
                //if the question is wrong
                else {
                    if (QuestionNumber == QuizBook.images.length) {
                        GameFinish();

                    } else {
                        updateQuestion();
                    }

                }
            }
        });
        return v;
    }

    private void updateQuestion() {
        QuestionImage.setImageResource(QuizBook.images[QuestionNumber]);
        Answer = QuizBook.answers[QuestionNumber];
        QuestionNumber++;
    }

    public void updateScore(int point) {
        tv_score.setText("" + point);
    }

    public void GameFinish() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new HomePage()).commit();
        //Initialize bundle
        Bundle bundle = new Bundle();
        //Put count value
        FirebaseDatabase
                .getInstance()
                .getReference()
                .child("users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("RojakPoint")
                .setValue(previousPoints + points)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("QUIZACTIVITY", "DATASAVED");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("QUIZACTIVITY", "DATASAVE FAILED");
                    }
                });
        bundle.putInt("finalScore", points);
        bundle.putInt("qustionNumber", QuestionNumber);
        //Initialize fragment
        ResultActivity resultActivity = new ResultActivity();
        //pass argument
        resultActivity.setArguments(bundle);
        //open fragment
        //getSupportFragmentManager()
        //       .beginTransaction()
        //     .replace(R.id.frame_layout, resultActivity)
        //   .commit();
        resultActivity.show(getActivity().getSupportFragmentManager(), "result activity");
    }

}