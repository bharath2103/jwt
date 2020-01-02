package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Component
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Optional<Employee> getEmployee(long id) {
		return repository.findById(id);
	}

}
