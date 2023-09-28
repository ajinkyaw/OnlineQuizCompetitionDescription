package com.demo.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	Map<Integer, String> answers = new HashMap<>();

	@Autowired
	private JDBCService jdbcService;

	@GetMapping("/register")
	public ModelAndView showLoginPage(ModelAndView model) {
		model.setViewName("register");
		return model;
	}

//	@PostMapping("/login-api")
//	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
//			Model model)
//
//	{
//		String respo = " ";
//		try {
//			jdbcService.registerUser(username, password);
//			respo = "success";
//			model.addAttribute("message", "Registration successful");
//		} catch (Exception e) {
//			respo = "failed";
//			model.addAttribute("message", "Registration failed");
//			e.printStackTrace(); // Print any exception details for debugging
//		}
//		return respo;
//	}

	@PostMapping("/register-api")
	public ModelAndView registerUser(@RequestParam("username") String username,
			@RequestParam("password") String password, 
			@RequestParam("userType") String userType, // Add user type																						// parameter
			ModelAndView model) {
		try {
			if ("student".equals(userType)) {
				jdbcService.registerStudent(username, password);
				model.setViewName("RegisterSuccessStudent"); // Set the view name to display the success JSP

			} else if ("teacher".equals(userType)) {
				jdbcService.registerTeacher(username, password);
				model.setViewName("RegisterSuccessTeacher"); // Set the view name to display the success JSP

			} else {
				// Handle invalid user type here (optional)
				model.addObject("message", "Invalid user type");
				model.setViewName("RegistrationFailed"); // Display another JSP for registration failure
				return model;
			}

		} catch (

		Exception e) {
			model.addObject("Registration Failed"); // Display another JSP for registration failure
			e.printStackTrace(); // Print any exception details for debugging
		}
		return model;
	}

	@GetMapping("/generateQuestion")
	public ModelAndView generateQuestion(ModelAndView model) {
		String message = "Add questions to the quiz here";
		model.addObject("message", message);
		model.setViewName("addQuestions");
		return model; // This corresponds to the view name (welcome.html)
	}

	@PostMapping("/generateQuestion-api")
	public ModelAndView addQuestion(
			@RequestParam("question") String questionStatement,
			@RequestParam("option1") String option1, 
			@RequestParam("option2") String option2,
			@RequestParam("option3") String option3, 
			@RequestParam("option4") String option4,
			@RequestParam("correct_answer") String correct_answer, 
			ModelAndView model)

	{
		String respo = " ";
		ArrayList<String> options_list = new ArrayList<String>();
		
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

	@GetMapping("/takeQuiz")
	public ModelAndView showQuiz(ModelAndView model) {
		try {
			ArrayList<Question> questions = jdbcService.getAllQuestions();
			System.out.println(questions);
			model.addObject("questions", questions);
			model.setViewName("displayQuiz"); // Set the name of your JSP page here
		} catch (SQLException e) {
			// Handle database-related exceptions
			e.printStackTrace();
			// You might want to return an error page here
			model.setViewName("error"); // Set the name of your error JSP page here
		}
		return model;
	}

//	@PostMapping("/takeQuiz-api")
//	public ModelAndView getAnswers(
//			@RequestParam("questions") String[] questions,
//			@RequestParam("options") String[][] options,
//			@RequestParam("selectedAnswer") String[] selectedCheckboxes,
//			ModelAndView model) {
//		try {
//			Map<String, Map<String, String>> quizData = new HashMap<>();
//			
//			for (int i = 0; i < questions.length; i++) {
//		        String question = questions[i];
//		        Map<String, String> questionData = new HashMap<>();
//
//		        for (int j = 0; j < options[i].length; j++) {
//		            String optionIndex = options[i][j];
//		            //String option = request.getParameter("questions[" + i + "]");
//		            questionData.put(option, optionIndex);
//		        }
//
//		        // Add question data to the quizData map
//		        quizData.put(question, questionData);
//		    }			
//
//		} catch (Exception e) {
//			model.addObject("Failed"); // Display another JSP for registration failure
//			e.printStackTrace(); // Print any exception details for debugging
//		}
//		return model;
//	}
	
	@PostMapping("/takeQuiz-api")
    public ModelAndView processQuizSubmission(
        @RequestParam("questions") String[] questions,
        @RequestParam("answers") String[][] answers,
        @RequestParam("selectedAnswers") String[] selectedAnswers) {
		
		

        // Create a map to store questions, user answers, and correct answers
        Map<String, Map<String, String>> quizData = new HashMap<>();

        for (int i = 0; i < questions.length; i++) {
            String question = questions[i];
            Map<String, String> questionData = new HashMap<>();

            for (int j = 0; j < answers[i].length; j++) {
                String optionIndex = answers[i][j];
                String option = questions[i]; // You can use the same question text
                questionData.put(option, optionIndex);
            }

            // Add question data to the quizData map
            quizData.put(question, questionData);
        }

        // Calculate the total score (you need to implement this method)
        int totalScore = calculateTotalScore(quizData);

        // Create a ModelAndView and set view name and model attributes
        ModelAndView modelAndView = new ModelAndView("quizResults");
        modelAndView.addObject("quizData", quizData);
        modelAndView.addObject("totalScore", totalScore);

        return modelAndView;
    }

    // Implement the calculateTotalScore method to calculate the total score
    private int calculateTotalScore(Map<String, Map<String, String>> quizData) {
        // Implement your scoring logic here
        // Calculate the total score based on correct answers
        return 0; // Replace with your scoring logic
    }
	
	
//	@GetMapping("/testQuiz")
//	public ModelAndView showTestQuiz(ModelAndView model) {
//		try {
//			ArrayList<Question> questions = jdbcService.getAllQuestions();
//			System.out.println(questions);
//			model.addObject("quiz", questions);
//			model.setViewName("sample"); // Set the name of your JSP page here
//		} catch (SQLException e) {
//			// Handle database-related exceptions
//			e.printStackTrace();
//			// You might want to return an error page here
//			model.setViewName("error"); // Set the name of your error JSP page here
//		}
//		return model;
//	}

	@GetMapping("/exit")
	public ModelAndView goToExitPage(ModelAndView model) {
		model.setViewName("exit");
		return model; // This corresponds to the view name (welcome.html)

	}
}
