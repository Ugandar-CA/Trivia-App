package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.triviaapp.Data.AnswerListAsyncResponse;
import com.example.triviaapp.Data.QuestionBank;
import com.example.triviaapp.Model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private TextView questionCounter;
    private ImageButton previousButton;
    private ImageButton nextButton;
    private Button trueButton;
    private Button falseButton;
    private List<QuestionModel> questionModelList;
    private int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.textBoard);
        questionCounter = findViewById(R.id.counter);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        previousButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);

        questionModelList = new QuestionBank().questionList(new AnswerListAsyncResponse() {
          @Override
        public void processFinished(ArrayList<QuestionModel> questionModelArrayList) {
              questionTextView.setText(questionModelArrayList.get(currentQuestionIndex).getQuestions());
            Log.d("hi", "processFinished: " + questionModelArrayList);
       }
    });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.previousButton:
                break;


        }

    }
}
