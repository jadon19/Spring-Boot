package com.restapi.employee.crud.rest;

import com.restapi.employee.crud.entity.Employee;
import com.restapi.employee.crud.repository.EmployeeRepository;
import com.restapi.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService es;
    private JsonMapper jp;
    @Autowired
    public EmployeeController(EmployeeService es , JsonMapper jp){
        this.es=es;
        this.jp=jp;

    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return es.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId){
            Employee emp = es.find(empId);
            if(emp==null){
                throw new RuntimeException(
                        "Employee id with id : " + empId +" not found!"
                );
            }
            return emp;
    }
//    For post request, we need our client to send data of employee in correct format
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee empBody){
//        If the user passes id , set it as 0
//        done to force save an item instead of update
        empBody.setId(0);
        return es.save(empBody);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody  Employee passedEmp){
        return es.save(passedEmp);
    }
    @DeleteMapping("employees/{empId}")
    public void deleteEmployee(@PathVariable int empId){
        es.deleteById(empId);
    }
    @PatchMapping("employees/{empId}")
    public Employee updateOnlyRequired(@PathVariable int empId,@RequestBody Map<String, Object> updates){

        Employee emp = es.find(empId);
//        if use is trying to update the primary key -> throw error
        if(updates.containsKey("id")){
            throw new RuntimeException("Cannot modify the identity key!");
        }
        if(emp == null){
            throw new RuntimeException("Employee not found");
        }
//
        jp.updateValue(emp,updates);
        return  es.save(emp);

    }
}
