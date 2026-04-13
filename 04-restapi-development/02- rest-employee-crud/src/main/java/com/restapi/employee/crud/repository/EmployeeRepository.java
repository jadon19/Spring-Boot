package com.restapi.employee.crud.repository;


import com.restapi.employee.crud.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee find(Integer i);
    Employee save(Employee emp);
    void deleteById(Integer i);
}
