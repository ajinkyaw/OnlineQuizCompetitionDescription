package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;

@Repository("QuizRepository")
public class QuizRepositoryImpl implements QuizRepository {

	ArrayList<Question> listOfQuestions = new ArrayList<Question>();
	ArrayList<Quiz> listOfQuizes = new ArrayList<Quiz>();
	
	//dynamic block	
//	{
//        Flight flight1 = new Flight(1, "New York", "Los Angeles", "08:00 AM");
//        Flight flight2 = new Flight(2, "Chicago", "Miami", "10:30 AM");
//        Flight flight3 = new Flight(3, "San Francisco", "Seattle", "09:15 AM");
//        Flight flight4 = new Flight(4, "Houston", "Denver", "11:45 AM");
//        Flight flight5 = new Flight(5, "Boston", "Washington, D.C.", "07:30 AM");
//        
//        listOfFlights.add(flight1);
//        listOfFlights.add(flight2);
//        listOfFlights.add(flight3);
//        listOfFlights.add(flight4);
//        listOfFlights.add(flight5);
//
//	}	
	@Override
	public String viewQuizScore() {
		return null;
	}

	@Override
	public String getQuizById(int quizId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAQuiz(Question question) {
		// TODO Auto-generated method stub
		return;
		
	}
}