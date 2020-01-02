package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {
	public Optional<User> getUserById(Long id);
	
	public User getUserByName(String name);
}
