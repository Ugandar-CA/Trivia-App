package com.example.triviaapp.Data;

import com.example.triviaapp.Model.QuestionModel;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<QuestionModel> questionModelArrayList);
}
