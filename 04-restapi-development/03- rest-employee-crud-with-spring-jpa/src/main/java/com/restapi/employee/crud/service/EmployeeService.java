package com.restapi.employee.crud.service;

import com.restapi.employee.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer i);
    Employee save(Employee emp);
    void deleteById(Integer i);
}
