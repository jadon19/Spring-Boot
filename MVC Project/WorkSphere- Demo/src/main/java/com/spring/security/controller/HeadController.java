package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeadController {
    @GetMapping("/")
    public String showHome() {
        return "index/landing-page";
    }




}