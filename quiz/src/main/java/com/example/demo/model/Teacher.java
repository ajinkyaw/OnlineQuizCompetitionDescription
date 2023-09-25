package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private String name;
	private List<Quiz> quizzes;

	public Teacher(String name) {
		this.name = name;
		this.quizzes = new ArrayList<>();
	}

	public void createQuiz(String title) {
		Quiz quiz = new Quiz(title);
		quizzes.add(quiz);
	}

	public void addQuestion(String quizName, Question question) {
//		if (quizIndex >= 0 && quizIndex < quizzes.size()) {
//			Quiz quiz = quizzes.get(quizIndex);
//			quiz.addQuestion(question);
//		} else {
//			System.out.println("Invalid quiz index.");
//		}
		//quiz.addQuestion(question);
	}

	public void removeQuestion(Quiz quiz, Question question) {
//		if (quizIndex >= 0 && quizIndex < quizzes.size()) {
//			Quiz quiz = quizzes.get(quizIndex);
//			quiz.removeQuestion(questionIndex);
//		} else {
//			System.out.println("Invalid quiz index.");
//		}
		quiz.removeQuestion(question);
	}

	public void viewStudentScore(Student student, Quiz quiz) {
//		if (quizIndex >= 0 && quizIndex < quizzes.size()) {
//			Quiz quiz = quizzes.get(quizIndex);
//			int score = student.calculateScore(quiz);
//			System.out.println(student.getName() + "'s score for " + quiz.getTitle() + ": " + score);
//		} else {
//			System.out.println("Invalid quiz index.");
//		}
		student.viewQuizScore(quiz);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
}
