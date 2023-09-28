package com.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.model.Question;
import com.demo.model.Student;

public class Quiz {
    private int id;
    private String title;
    private List<Question> questions;
    private Map<Student, Integer> studentScores; // Map to store student scores

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
        this.studentScores = new HashMap<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public void addStudentScore(Student student, int score) {
        studentScores.put(student, score);
    }

    public int getStudentScore(Student student) {
        return studentScores.getOrDefault(student, -1); // -1 indicates no score recorded
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
