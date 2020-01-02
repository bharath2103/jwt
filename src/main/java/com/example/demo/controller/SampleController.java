package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class SampleController {
	
	@Autowired
	private UserService userservice;
	
	@ResponseBody
	@GetMapping("/hello")
	public String sampleGreet() {
		return "Welcome";
	}

	/*@ResponseBody
	@GetMapping("/getuser/{id}")
	public User getUser(@PathVariable("id") String id) {
		User outerUser = null;
		Long userId = Long.parseLong(id);
		Optional<User> optionalUser = userservice.getUserById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			outerUser = user;
		}
		return outerUser;
	}*/
	
	
}
