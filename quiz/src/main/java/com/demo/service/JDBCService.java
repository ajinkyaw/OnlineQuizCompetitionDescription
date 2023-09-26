package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.demo.model.Question;
import com.demo.util.JDBCUtil;

@Service
public class JDBCService {

	public void registerTeacher(String username, String password) {
	    try {
	        Connection connection = JDBCUtil.getConnection();

	        String teacherToInsert = "INSERT INTO teacher (userName, userPassword) VALUES (?, ?)";

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

	        String studentToInsert = "INSERT INTO student (userName, userPassword) VALUES (?, ?)";

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

	
	
    
   public static void insertQuestion(Question question) throws SQLException{

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


