package com.veeru.springbootjwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.veeru.springbootjwt.dao.UserDetailsDao;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<com.veeru.springbootjwt.model.UserDetails> userDetailsList =userDetailsDao.findAllByUserName(username);
		com.veeru.springbootjwt.model.UserDetails userDetails = null;
		if(userDetailsList !=null && userDetailsList.size()>=1) {
			userDetails = userDetailsList.get(0);
		}
		if(userDetails!=null) {
			return new User(userDetails.getUserName(), userDetails.getPassword(),
					new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		/*
		 * if ("javainuse".equals(username)) { return new User("javainuse",
		 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
		 * ArrayList<>());
		 */
		/*} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}*/
	}

}
