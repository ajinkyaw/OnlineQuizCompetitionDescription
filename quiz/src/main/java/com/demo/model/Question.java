package com.demo.model;

import java.util.ArrayList;

public class Question {

	private int id;

	private String questionStatement;

	private ArrayList<String> options;

	private String correctAnswer;

	public Question(String questionStatement, ArrayList<String> options, String correctAnswer) {

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

	public ArrayList<String> getOptions() {

		return options;

	}

	public void setOptions(ArrayList<String> options) {

		this.options = options;

	}

	public String getCorrectAnswer() {

		return correctAnswer;

	}

	public void setCorrectAnswer(String correctAnswer) {

		this.correctAnswer = correctAnswer;

	}

//	@Override
//
//	public String toString() {
//
//		return "Question{" + "id=" + id + "," + "questionStatement=" + questionStatement + "}" + "Options" + options;
//
//	}

}