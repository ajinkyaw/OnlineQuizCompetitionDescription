package com.example.demo.model;

import java.util.List;

public class Question {
    private int id;
    private String questionStatement;
    private List<String> options;
    private String correctAnswer;

    public Question() {
        // Default constructor
    }

    public Question(String questionStatement, List<String> options, String correctAnswer) {
        this.questionStatement = questionStatement;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String text) {
        this.questionStatement = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}