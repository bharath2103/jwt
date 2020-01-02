package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	

	@GetMapping("/hello")
	@ResponseBody
	public String sampleGreet() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String userlogin() {
		return "user logged in";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminlogin() {
		return "admin logged in";
	}
	
}
