package com.restapi.employee.crud.service;

import com.restapi.employee.crud.entity.Employee;
import com.restapi.employee.crud.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleEmployeeService implements EmployeeService{
    private EmployeeRepository repo;
    @Autowired
    public SimpleEmployeeService(EmployeeRepository repo){
        this.repo=repo;

    }
    @Override
    public List<Employee> findAll(){
        return repo.findAll();
    }
    @Override
    public Employee find(Integer id){
        return repo.find(id);
    }
    @Transactional
    @Override
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    @Transactional
    @Override
    public void deleteById(Integer i) {
        repo.deleteById(i);
    }
}
