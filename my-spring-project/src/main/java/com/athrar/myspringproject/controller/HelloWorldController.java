package com.athrar.myspringproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

	//private static final Logger LOGGER= LogManager.getLogger(HelloWorldController.class);
	@GetMapping
	public String greetUser() {
		//LOGGER.info("Request Recieved");
		return "hey, there!";
	}
}
