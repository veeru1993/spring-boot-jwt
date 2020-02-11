package com.veeru.springbootjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.veeru.springbootjwt.dao.UserDetailsDao;
import com.veeru.springbootjwt.model.UserDetails;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	public String userRegistartion(UserDetails ud) {		
		ud.setPassword(passwordEncoder(ud.getPassword()));
		UserDetails udSave=userDetailsDao.save(ud);
		
		if(udSave!=null) return "Successfullay Registered";
		else return "some thing wrong Registeration failed";
	}
	
	public String passwordEncoder(String password) {
		return new BCryptPasswordEncoder().encode(password);		
	}
}
