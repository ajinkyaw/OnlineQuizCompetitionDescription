package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuizRepository;

@Service("QuizService")
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QuizRepository obj;

//	@Override
//	public String getAllFlights() {
//		return obj.getAllFlights().toString();
//	}
//
//	@Override
//	public String getFlightById(int flightId) {
//		return obj.getFlightById(flightId);
//	}
//
//	@Override
//	public void createABooking(Booking book) {
//		obj.createABooking(book);
//
//	}

//	@Override
//	public void createABooking(com.example.demo.services.Booking book) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public String viewQuizScore() {
		// TODO Auto-generated method stub
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
		
	}
}