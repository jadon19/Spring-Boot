package com.firstspringboot.project.spring_boot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
            return "hello world";
        }
    @GetMapping("/workout")
    public String getMyWorkout(){
        return "WORK hard";
    }
    @GetMapping("/fortune")
    public String getMyFortune(){
        return "your lucky day!!!";
    }
}
