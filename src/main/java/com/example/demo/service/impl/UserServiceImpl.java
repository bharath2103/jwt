package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getUserById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		return user;
		
	}
	
	public User getUserByName(String name) {
		
		User user = userRepository.getUserByName(name);
		return user;
		
	}

}
