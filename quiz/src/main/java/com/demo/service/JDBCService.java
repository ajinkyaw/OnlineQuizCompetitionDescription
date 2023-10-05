package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.model.Question;
import com.demo.util.JDBCUtil;

@Service
public class JDBCService {

	public void registerTeacher(String username, String password) {
		try {
			Connection connection = JDBCUtil.getConnection();

			String teacherToInsert = "INSERT INTO teacherdata (username, password) VALUES (?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(teacherToInsert);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			int rowsAffected = preparedStatement.executeUpdate();

			connection.close();

			if (rowsAffected > 0) {
				System.out.println("Teacher registered successfully");
			} else {
				System.out.println("Teacher registration failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void registerStudent(String username, String password) {
		try {
			Connection connection = JDBCUtil.getConnection();

			String studentToInsert = "INSERT INTO studentdata (username, password) VALUES (?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(studentToInsert);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			int rowsAffected = preparedStatement.executeUpdate();

			connection.close();

			if (rowsAffected > 0) {
				System.out.println("Student registered successfully");
			} else {
				System.out.println("Student registration failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertQuestion(Question question) throws SQLException {

		String INSERT_QUESTION_SQL = "INSERT INTO quizdata (question, option1, option2, option3, option4, correctAnswer) VALUES (?, ?, ?, ?, ?, ?)";

		Connection connection = JDBCUtil.getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTION_SQL)) {

			preparedStatement.setString(1, question.getQuestionStatement());

			preparedStatement.setString(2, question.getOptions().get(0));

			preparedStatement.setString(3, question.getOptions().get(1));

			preparedStatement.setString(4, question.getOptions().get(2));

			preparedStatement.setString(5, question.getOptions().get(3));

			preparedStatement.setString(6, question.getCorrectAnswer());

			preparedStatement.executeUpdate();

		} finally {

			if (connection != null) {

				connection.close();

			}

		}

	}

	public ArrayList<Question> getAllQuestions() throws SQLException {

		ArrayList<Question> questions = new ArrayList<>();

		String SELECT_QUESTIONS_SQL = "SELECT * FROM quizdata";

		Connection connection = JDBCUtil.getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTIONS_SQL);

				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {

				String text = resultSet.getString("question");

				String option1 = resultSet.getString("option1");

				String option2 = resultSet.getString("option2");

				String option3 = resultSet.getString("option3");

				String option4 = resultSet.getString("option4");

				String correctAnswer = resultSet.getString("correctAnswer");

				ArrayList<String> options = new ArrayList<>();

				options.add(option1);

				options.add(option2);

				options.add(option3);

				options.add(option4);

				Question question = new Question(text, options, correctAnswer);

				questions.add(question);

			}

		} finally {

			if (connection != null) {

				connection.close();

			}

		}

		return questions;
	}

	// Implement the calculateTotalScore method
	public int calculateTotalScore(Map<String, Integer> userAnswers) {
		int score = 0;
		try {

			Connection connection = JDBCUtil.getConnection();
			// Iterate through the userAnswers map
			for (Map.Entry<String, Integer> entry : userAnswers.entrySet()) {
				
				String question = entry.getKey();
				System.out.println("from map" + question);
				int selectedOptionIndex = entry.getValue();
				System.out.println("from map" + selectedOptionIndex);

				// Map the selected option index to the corresponding option column (option1,
				// option2, ...)
				String selectedOptionColumn = "option" + (selectedOptionIndex + 1);

				// Fetch the correct answer from the database
				String query = "SELECT correctAnswer FROM quizdata WHERE question = ?";

				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, question);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					String correctAnswer = resultSet.getString("correctAnswer");
					// Compare the correct answer with the selected answer
					if (selectedOptionColumn.equals(correctAnswer)) {
						// Increment the score for a correct answer
						score += 10;
						System.out.println(score);
					}
				}

				// Close resources
				resultSet.close();
				preparedStatement.close();
			}

			// Close the database connection
			connection.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}
	
	//returning user selected answer in words
	public ArrayList<String> returnAnswer(Map<String, Integer> userAnswers) {
	    ArrayList<String> userSelectedAnswers = new ArrayList<String>(); // Use String type for userAnswers
	    ArrayList<String> correctAnswers = new ArrayList<String>(); //correct answers

	    try {
	        Connection connection = JDBCUtil.getConnection();

	        // Iterate through the userAnswers map
	        for (Map.Entry<String, Integer> entry : userAnswers.entrySet()) {
	            String question = entry.getKey();
	            int userSelectedOptionIndex = entry.getValue();

	            // Map the selected option index to the corresponding option column (option1, option2, ...)
	            String userSelectedOptionColumn = "option" + (userSelectedOptionIndex + 1);

	            // Fetch the correct answer and value in words from the database
	            String query = "SELECT correctAnswer, " + userSelectedOptionColumn + " FROM quizdata WHERE question = ?";

	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, question);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                String selectedOptionValue = resultSet.getString(userSelectedOptionColumn);
	                String correctOptionValue = resultSet.getString("correctAnswer");
	                userSelectedAnswers.add(selectedOptionValue); // Add the value in words to the list
	                correctAnswers.add(correctOptionValue);
	            }
	            // Close resources
	            resultSet.close();
	            preparedStatement.close();
	        }

	        // Close the database connection
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userSelectedAnswers;
	}
	
	//returning correct answers in words
	public ArrayList<String> returnCorrectAnswers(Map<String, Integer> userAnswers) {
		ArrayList<String> temp = new ArrayList<String>();
	    ArrayList<String> correctAnswers = new ArrayList<String>(); //correct answers

	    try {
	        Connection connection = JDBCUtil.getConnection();

	        // Iterate through the userAnswers map
	        for (Map.Entry<String, Integer> entry : userAnswers.entrySet()) {
	            String question = entry.getKey();

	            // Fetch the correct answer and value in words from the database
	            String query = "SELECT correctAnswer FROM quizdata WHERE question = ?";

	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, question);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                //String selectedOptionValue = resultSet.getString(userSelectedOptionColumn);
	                String correctOptionValue = resultSet.getString("correctAnswer");
	                //userSelectedAnswers.add(selectedOptionValue); // Add the value in words to the list
	                temp.add(correctOptionValue);
	                
	                String query2 = "SELECT " + correctOptionValue + " FROM quizdata WHERE question = ?";
	                
	                PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
		            preparedStatement2.setString(1, question);
		            ResultSet resultSet2 = preparedStatement2.executeQuery();
		            
		            if (resultSet2.next()) {
		            	String selectedValue = resultSet2.getString(correctOptionValue);
		            	correctAnswers.add(selectedValue);
		            }
	            }
	            
	            // Close resources
	            resultSet.close();
	            preparedStatement.close();
	        }

	        // Close the database connection
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return correctAnswers;
	}

}
