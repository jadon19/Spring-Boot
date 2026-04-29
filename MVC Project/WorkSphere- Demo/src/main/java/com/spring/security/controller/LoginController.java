package com.spring.security.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "index/login";
    }
    @GetMapping("/dashboard")
    public String showDashboard(){
        return "employee/home";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "index/access-denied-page";
    }
}
