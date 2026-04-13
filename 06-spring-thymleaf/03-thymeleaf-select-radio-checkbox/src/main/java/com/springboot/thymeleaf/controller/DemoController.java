package com.springboot.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class DemoController {
    @Value("${locations}")
    private List<String> locations;


    @Value("${languages}")
    private List<String> languages;

    @Value("${operating}")
    private List<String> operatingSystems;

    @GetMapping("/fillLocation")
    public String enterLocation(Model model){
        model.addAttribute("locations",locations);
        model.addAttribute("languages",languages);
        model.addAttribute("os",operatingSystems);
        return "home";
    }
    @PostMapping("/displayLocation")
    public String displayLocation(@RequestParam("loc") String loc,@RequestParam("lan") String lan ,@RequestParam("opsys") List<String> listOfOs, Model model) {
        model.addAttribute("selectedLocation", loc);
        model.addAttribute("selectedLanguage",lan);
        model.addAttribute("selectedOs",listOfOs);
        return "details";
    }

}
