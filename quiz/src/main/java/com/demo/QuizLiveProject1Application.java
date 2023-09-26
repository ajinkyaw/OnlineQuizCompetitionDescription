package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class QuizLiveProject1Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(QuizLiveProject1Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{
		return application.sources(QuizLiveProject1Application.class);
	}	
}
