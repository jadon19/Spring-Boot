package com.springboot.cruddemo.controller;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService es;
    @Autowired
    public EmployeeController(EmployeeService es){
        this.es = es;
    }
    @GetMapping("/list")
    public String listEmployees(Model model){
//        get employees from db
        List<Employee> emps  = es.findAll();
//        add that to the spring model
        model.addAttribute("employees",emps);
        return "list-employees";
    }
    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "add-employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee tempEmployee){
        es.save(tempEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, Model model){
        Employee temp = es.findById(id);
        if(temp==null){
            return "list-employees";
        }
        model.addAttribute("employee",temp);
        return "add-employee-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model){
        es.deleteById(id);
        return "redirect:/employees/list";
    }
}
