package com.example.demo.confing;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;


import com.example.demo.model.Employee;
import com.example.demo.reposatory.EmployeeResps;

@Component
public class StateUp implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	@Autowired
	private EmployeeResps employeerepos;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		jdbcTemplate.execute("DROP TABLE IF EXISTS employee");
		
		jdbcTemplate.execute("CREATE TABLE employee(id SERIAL, name VARCHAR(255) , salary NUMERIC(15,2))");
		
		if (employeerepos.count() == 0 ) {
		employeerepos.insert(new Employee(20L,"III",66.08));
		employeerepos.insert(new Employee(30L,"III",66.08));
		employeerepos.insert(new Employee(40L,"III",66.08));
		employeerepos.insert(new Employee(50L,"III",66.08));
		
	}}

}
