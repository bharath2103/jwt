package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import com.example.demo.model.UserDetails;

@Configuration
public class DemoConfig {
	public UserDetails getUserDetails() {
		return new UserDetails();
	}
}
