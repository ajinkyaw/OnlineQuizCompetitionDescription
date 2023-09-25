package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Question;

@Repository
public interface QuizRepository {

	public String viewQuizScore();

	public String getQuizById(int flightId);

	public void createAQuiz(Question question);
	
//	public void takeThisQuiz(User user)

}