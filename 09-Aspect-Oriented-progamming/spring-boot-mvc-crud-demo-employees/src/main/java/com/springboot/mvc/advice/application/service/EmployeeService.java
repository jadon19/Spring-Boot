package com.springboot.mvc.advice.application.service;

import java.util.List;

import com.springboot.mvc.advice.application.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
