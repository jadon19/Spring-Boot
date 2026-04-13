package com.restapi.employee.crud.service;

import com.restapi.employee.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee find(Integer i);
    Employee save(Employee emp);
    void deleteById(Integer i);
}
