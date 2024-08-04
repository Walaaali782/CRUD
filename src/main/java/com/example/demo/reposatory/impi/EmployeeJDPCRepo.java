package com.example.demo.reposatory.impi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.reposatory.EmployeeResps;

import com.example.demo.mapper.EmployeeMapper;
@Component
public class EmployeeJDPCRepo implements EmployeeResps  {

	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	
	@Override
	public int count() {
		
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee", Integer.class);
	}

	@Override
	public Employee findbyid(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select id, name, salary from employee where id = ?", new Object[] {id}
		, new EmployeeMapper());
//		, (rs,rowNum) ->
//		new Employee(rs.getLong("id"),rs.getString("name"),rs.getDouble("salary"))
//		);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select id, name, salary from employee ", new EmployeeMapper());
	}

	@Override
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into employee (id,name,salary) values(?,?,?)",
				
				new Object [] {employee.getId() , employee.getName() , employee.getSalary()});
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
return jdbcTemplate.update("update employee set name= ?, salary= ?",
				
				new Object [] {employee.getName() , employee.getSalary()});
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
return jdbcTemplate.update("delete from employee where id = ?",
				
				new Object [] {id});
	}

}
