package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
    @GetMapping("/manager")
    public String managerDashboard(){
        return "manager/manager-page";
    }
}
