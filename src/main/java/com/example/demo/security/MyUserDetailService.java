package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userService.getUserByName(username);
		MyUserDetails myUserDetails = new MyUserDetails(user.getName(), user.getPassword());
		return myUserDetails;
	}
}