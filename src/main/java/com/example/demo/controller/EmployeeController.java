package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.reposatory.EmployeeResps;

@Component
@RestController
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	private EmployeeResps employeeresps;
	
	@GetMapping("/count")
	public int countEmployee() {
		return employeeresps.count();
	}
	
	@GetMapping("/{id}")
	public Employee findbyid(@PathVariable Long id) {
		return employeeresps.findbyid(id);
	}
	
	@GetMapping("")
	public List<Employee> findAll() {
		return employeeresps.findAll();
	}
}
