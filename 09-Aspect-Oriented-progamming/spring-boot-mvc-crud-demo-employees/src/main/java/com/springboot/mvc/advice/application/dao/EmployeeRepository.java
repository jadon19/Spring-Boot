package com.springboot.mvc.advice.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.mvc.advice.application.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}
