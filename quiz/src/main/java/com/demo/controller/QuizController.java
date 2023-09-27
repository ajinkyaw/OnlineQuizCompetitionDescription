package com.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Question;
import com.demo.service.JDBCService;

@RestController
public class QuizController {

	@Autowired
	private JDBCService jdbcService;

	@GetMapping("/register")
	public ModelAndView showLoginPage(ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	@PostMapping("/register-api")
	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("userType") String userType, // Add user type parameter
			Model model) {
		String respo = " ";
		try {
			if ("student".equals(userType)) {
				jdbcService.registerStudent(username, password);
			}

			else if ("teacher".equals(userType)) {
				jdbcService.registerTeacher(username, password);
			}

			else {
				// Handle invalid user type here (optional)
				respo = "failed";
				model.addAttribute("message", "Invalid user type");
				return respo;
			}

			respo = "success";
			model.addAttribute("message", "Registration successful");

		} catch (Exception e) {
			respo = "failed";
			model.addAttribute("message", "Registration failed");
			e.printStackTrace(); // Print any exception details for debugging
		}
		return respo;
	}

	@GetMapping("/generateQuestion")
	public ModelAndView generateQuestion(ModelAndView model) {
		String message = "Add questions to the quiz here";
		model.addObject("message", message);
		model.setViewName("addQuestions");
		return model; // This corresponds to the view name (welcome.html)
	}

	@PostMapping("/generateQuestion-api")
	public ModelAndView addQuestion(@RequestParam("question") String questionStatement,
			@RequestParam("option1") String option1, @RequestParam("option2") String option2,
			@RequestParam("option3") String option3, @RequestParam("option4") String option4,
			@RequestParam("correct_answer") String correct_answer, ModelAndView model)

	{
		String respo = " ";
		ArrayList<String> options_list = new ArrayList<String>();

		// options_list = Arrays.asList(option1,option2,option3,option4);
		options_list.add(option1);
		options_list.add(option2);
		options_list.add(option3);
		options_list.add(option4);

		Question question = new Question(questionStatement, options_list, correct_answer);

		try {
			jdbcService.insertQuestion(question);
			model.setViewName("dashboard");

		} catch (Exception e) {
			e.printStackTrace(); // Print any exception details for debugging
		}

		return model;
	}

	@GetMapping("/dashboard")
	public ModelAndView dashboard(ModelAndView model) {
		String message = "Question added";
		model.addObject("message", message);
		model.setViewName("dashboard");
		return model; // This corresponds to the view name (welcome.html)
	}

	@GetMapping("/studentDashboard/takeQuiz")
	public ModelAndView showQuiz(ModelAndView model) {
		try {
			ArrayList<Question> questions = jdbcService.getAllQuestions();
			System.out.println(questions);
			model.addObject("quiz", questions);
			model.setViewName("displayQuiz"); // Set the name of your JSP page here
		} catch (SQLException e) {
			// Handle database-related exceptions
			e.printStackTrace();
			// You might want to return an error page here
			model.setViewName("error"); // Set the name of your error JSP page here
		}
		return model;
	}
}
