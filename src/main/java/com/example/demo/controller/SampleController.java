package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Employee;
import com.example.demo.model.UserDetails;
import com.example.demo.service.IEmployeeService;

@Controller
public class SampleController {
	
	private UserDetails userDetails;
	
	@Autowired
	private IEmployeeService employeeService;
	

	@Autowired
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@GetMapping("/hello")
	@ResponseBody
	public UserDetails sampleGreet() {
		return userDetails;
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
	
	@GetMapping("/getemployee/{id}")
	@ResponseBody
	public String getEmployee(@PathVariable("id") String id) {
		Employee empl = null;
		Long employeeId = Long.parseLong(id);
		Optional<Employee> emp = employeeService.getEmployee(employeeId);
		if(emp.isPresent()){
			empl = emp.get();
		}
		return empl.toString();
	}
	
	
}
