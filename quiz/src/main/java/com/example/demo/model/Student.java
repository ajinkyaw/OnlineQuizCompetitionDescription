package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Quiz> quizzesTaken;

    public Student(String name) {
        this.name = name;
        this.quizzesTaken = new ArrayList<>();
    }

    public void submitQuiz(Quiz quiz, List<String> studentAnswers) {
        // Ensure the quiz exists and contains questions
        if (quiz != null && !quiz.getQuestions().isEmpty()) {
            int score = calculateScore(quiz, studentAnswers);
            quiz.addStudentScore(this, score);
            quizzesTaken.add(quiz);
        } else {
            System.out.println("Quiz does not exist or has no questions.");
        }
    }

    public void viewAllQuizzes(List<Quiz> allQuizzes) {
        System.out.println("All Quizzes:");
        for (int i = 0; i < allQuizzes.size(); i++) {
            System.out.println((i + 1) + ". " + allQuizzes.get(i).getTitle());
        }
    }

    public void viewQuizScore(Quiz quiz) {
        if (quizzesTaken.contains(quiz)) {
            int score = quiz.getStudentScore(this);
            System.out.println("Your score for " + quiz.getTitle() + ": " + score);
        } else {
            System.out.println("You have not taken this quiz.");
        }
    }

    private int calculateScore(Quiz quiz, List<String> studentAnswers) {
        int score = 0;
        List<Question> questions = quiz.getQuestions();

        if (studentAnswers.size() != questions.size()) {
            return score; // No partial scoring; all questions must be answered.
        }

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            String studentAnswer = studentAnswers.get(i);

            if (studentAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }

        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quiz> getQuizzesTaken() {
        return quizzesTaken;
    }

    public void setQuizzesTaken(List<Quiz> quizzesTaken) {
        this.quizzesTaken = quizzesTaken;
    }
}
