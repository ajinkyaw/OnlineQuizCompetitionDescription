package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Question;
import com.example.demo.services.QuizService;

@RestController
public class QuizController {

	@Autowired
	QuizService obj;

	@GetMapping("/dashboard")
	public ModelAndView dashboard(ModelAndView model) {
		String message = "Welcome to our Spring Boot application!";
		model.addObject("message", message);
		model.setViewName("addQuestions");
		return model; // This corresponds to the view name (welcome.html)
	}

	@GetMapping("/register")
	public ModelAndView registration(ModelAndView model) {
		String message = "Welcome to a registeration page1";
		model.addObject("message", message);
		model.setViewName("UserRegisteration");
		return model; // This corresponds to the view name (welcome.html)
	}

	@GetMapping("/generateQuestion")
	public ModelAndView generateQuestion(ModelAndView model) {
		String message = "Add questions to the quiz here";
		model.addObject("message", message);
		model.setViewName("addQuestions");
		return model; // This corresponds to the view name (welcome.html)
	}

	@GetMapping("/login")
	public ModelAndView showLoginPage(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

//	@PostMapping("/login-api")
//	public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
//			Model model)
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
//
//	@PostMapping("/generateQuestion-api")
//	public String addQuestion(@RequestParam("question") String questionStatement,
//			@RequestParam("option1") String option1,
//			@RequestParam("option2") String option2,
//			@RequestParam("option3") String option3,
//			@RequestParam("option4") String option4,
//			@RequestParam("correct_answer") String correct_answer,
//			Model model)
//	{
//		String respo = " ";
//		ArrayList<String> options_list = new ArrayList<String>();
//		// options_list = Arrays.asList(option1,option2,option3,option4);
//		options_list.add(option1);
//		options_list.add(option2);
//		options_list.add(option3);
//		options_list.add(option4);
//
//		Question question = new Question(questionStatement, options_list, correct_answer);
//
//		try {
//			jdbcService.insertQuestion(question);
//			// respo = "success";
//			model.addAttribute("message", "Question added");
//			return "redirect:/dashboard";
//		} catch (Exception e) {
//			// respo = "failed";
//			model.addAttribute("message", "Registration failed");
//			e.printStackTrace(); // Print any exception details for debugging
//		}
//		return "errorPage";
//	}
}