package com.example.demo.reposatory;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeResps {

	int count ();
	
	Employee findbyid (Long id);
	
	List<Employee> findAll ();
	
	int insert (Employee employee);
	
	int update (Employee employee);

	int delete (Long id);
}
