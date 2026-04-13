package com.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    @RequestMapping("/showName")
    public String showName(Model mymodel){
        mymodel.addAttribute("name","tanishka");
        return "name";
    }
    @RequestMapping("/employees")
    public String employees(Model mymodel){
        List <String> myEmployees = new ArrayList<>();
        myEmployees.add("tanishka");
        myEmployees.add("priya jadon");
        mymodel.addAttribute("emps",myEmployees);
        return "emps.html";
    }
    @RequestMapping("/checkAge")
    public String checkAge(Model mymodel){
        mymodel.addAttribute("age",20);
        return "validation.html";
    }

    @RequestMapping("/form")
    public String form(Model model){
        model.addAttribute("userName","tanishka");
        return "inputForm";
    }

}
