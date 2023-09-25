package com.example.demo.services;


import org.springframework.stereotype.Service;
import com.example.demo.model.Question;

@Service
public interface QuizService {

	public String viewQuizScore();

	public String getQuizById(int quizId);

	public void createAQuiz(Question question);

}