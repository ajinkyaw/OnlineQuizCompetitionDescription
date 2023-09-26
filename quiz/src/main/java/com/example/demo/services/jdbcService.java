package com.example.demo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.util.JDBCUtil;

@Service
public class jdbcService {

	public void registerUser(String username, String password) {
		try {
			// Insert data into the database using JDBC
			Connection connection = JDBCUtil.getConnection();

			String userToInsert = "INSERT INTO userdata (userName, userPassword) VALUES (?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(userToInsert);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			int rowsAffected = preparedStatement.executeUpdate();

			connection.close();

			if (rowsAffected > 0) {
				System.out.println("User registered successfully");
			} else {
				System.out.println("User registration failed");
			}
		}

		catch (SQLException e) {
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
	
	
}