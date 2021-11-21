package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView tv_score;
    private ImageView QuestionImage;
    private Button trueBtn, falseBtn;

    private boolean Answer;
    private int points = 0;
    private int QuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv_score = (TextView) findViewById(R.id.points);
        QuestionImage = (ImageView) findViewById(R.id.iv_ques1);
        trueBtn = (Button) findViewById(R.id.btn_true);
        falseBtn = (Button) findViewById(R.id.btn_false);

        updateQuestion();

        //Logic for True Button
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences sharedPreferences = getSharedPreferences(QuizActivity.PREFS_NAME,0);
                //SharedPreferences.Editor editor = sharedPreferences.edit();

                //editor.putBoolean("hasLoggedIn", true);
                //editor.commit();

                if(Answer == true){
                    Toast.makeText(QuizActivity.this, "You are correct", Toast.LENGTH_SHORT).show();
                    points = points + 1; //This update the score int variables
                    updateScore(points); //This convert the int variables to a String and adds it to score

                    //Perform this check before you update the question
                    if(QuestionNumber == QuizBook.images.length){
                        GameFinish();
                        //Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putInt("finalScore", points);
                        //i.putExtras(bundle);
                        //QuizActivity.this.finish();
                        //startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
                //if the question is wrong
                else {
                    if(QuestionNumber == QuizBook.images.length){
                        GameFinish();
                        //Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putInt("finalScore", points);
                        //i.putExtras(bundle);
                        //QuizActivity.this.finish();
                        //startActivity(i);
                    }else {
                        updateQuestion();
                    }

                }
            }
        });

        //Logic for false Button
        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Answer == false){
                    Toast.makeText(QuizActivity.this, "You are correct", Toast.LENGTH_SHORT).show();
                    points++; //This update the score int variables
                    updateScore(points); //This convert the int variables to a String and adds it to score

                    //Perform this check before you update the question
                    if(QuestionNumber == QuizBook.images.length){
                        GameFinish();

                    }else {
                        updateQuestion();
                    }
                }
                //if the question is wrong
                else {
                    if(QuestionNumber == QuizBook.images.length){
                        GameFinish();

                    }else {
                        updateQuestion();
                    }

                }
            }
        });

    }
    private void updateQuestion(){
        QuestionImage.setImageResource(QuizBook.images[QuestionNumber]);
        Answer = QuizBook.answers[QuestionNumber];
        QuestionNumber++;
    }

    public void updateScore(int point){
        tv_score.setText("" + point);
    }

    public void GameFinish(){
        //Initialize bundle
        Bundle bundle = new Bundle();
        //Put count value
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
        resultActivity.show(getSupportFragmentManager(), "result activity");
    }

}