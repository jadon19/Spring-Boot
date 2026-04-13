package com.restapi.employee.crud.service;

import com.restapi.employee.crud.entity.Employee;
import com.restapi.employee.crud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleEmployeeService implements EmployeeService{
    private EmployeeRepo repo;
    @Autowired
    public SimpleEmployeeService(EmployeeRepo repo){
        this.repo=repo;

    }
    @Override
    public List<Employee> findAll(){
        return repo.findAll();
    }
    @Override
    public Employee findById(Integer id){
        Optional<Employee> result = repo.findById(id);
        Employee emp = null;
        if(result.isPresent()){
            emp = result.get();
            return emp;
        }
        else{
            throw new RuntimeException("Employee not found !");
        }
    }
    @Override
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public void deleteById(Integer i) {
        repo.deleteById(i);
    }
}
