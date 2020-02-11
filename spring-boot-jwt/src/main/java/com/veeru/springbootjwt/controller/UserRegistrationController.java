package com.veeru.springbootjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veeru.springbootjwt.model.UserDetails;
import com.veeru.springbootjwt.service.UserRegistrationService;

@RestController
@RequestMapping("/trusted")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;

	@PostMapping("/userRegistration")
	public String userRegistration(@RequestBody UserDetails userDetails) {
		System.out.println("UserDetails :"+userDetails.toString());
		return userRegistrationService.userRegistartion(userDetails);		
	}
	
}
