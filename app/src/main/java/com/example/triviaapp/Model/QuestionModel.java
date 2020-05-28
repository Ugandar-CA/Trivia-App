package com.example.triviaapp.Model;

public class QuestionModel {

    private String questions ;
    private Boolean trueOrFalse;

    public QuestionModel(){

    }

    public QuestionModel(String questions, Boolean trueOrFalse) {
        this.questions = questions;
        this.trueOrFalse = trueOrFalse;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        questions = questions;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }
}
