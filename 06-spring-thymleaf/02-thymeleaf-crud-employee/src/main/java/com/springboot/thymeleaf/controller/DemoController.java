package com.springboot.thymeleaf.controller;

import com.springboot.thymeleaf.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class DemoController {

    private List<Employee> myEmployees = new ArrayList<>();

    public DemoController() {

        myEmployees.add(new Employee(1,"Tanishka Jadon", "IT"));
        myEmployees.add(new Employee(2,"Ram Pratap Singh", "HR"));
    }

    @GetMapping
    public String displayEmployees(Model model) {
        model.addAttribute("employees", myEmployees);
        return "homepage";
    }

//    Using model container (model->form->view)
    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("emp", new Employee());
        return "addEmployee";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee emp){

        myEmployees.add(emp);
        return "redirect:/employees";
    }

//    Using @RequestParam
    @GetMapping("/addByParam")
    public String addEmployee(){
        return "addEmployeeWithoutModel";
    }
    @PostMapping("/addByParam")
    public String addEmployee(@RequestParam("passedName") String Name,@RequestParam("passedDept") String Dept){
        myEmployees.add(new Employee(myEmployees.size()+1,Name,Dept));
        return "redirect:/employees";
    }

//    Model is used to pass data to the view, while @ModelAttribute is used to bind request data to a Java object.
//Without th:object and th:field, you use name attributes in HTML and @RequestParam in controller to manually retrieve values.
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        myEmployees.removeIf(emp -> emp.getId() == id);
        return "redirect:/employees";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {

        Employee emp = myEmployees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        model.addAttribute("emp", emp);
        return "updateEmployee";
    }
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @ModelAttribute Employee updatedEmp){

        for (Employee emp : myEmployees) {
            if (emp.getId() == id) {
                emp.setName(updatedEmp.getName());
                emp.setDept(updatedEmp.getDept());
                break;
            }
        }

        return "redirect:/employees";
    }
}

