package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @GetMapping("/profile")
    public String profile(){
    return "employee/employee-profile";
    }
    @GetMapping("/timesheet")
    public String timesheet(){
    return "employee/timesheet";
    }
    @GetMapping("/leave")
    public String applyLeave(){
    return "employee/leave";
    }
    @GetMapping("/team")
    public String teamMembers(){
    return "employee/team";
    }
    }
