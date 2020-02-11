package com.veeru.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Welcome to Veeru Programing World.";
	}
}
