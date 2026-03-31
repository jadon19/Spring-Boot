package com.firstspringboot.project.spring_boot.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {
//    injecting properties into application
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


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
    @GetMapping("/values")
    public String getValues(){
        return "Coach name :"+coachName+"team name : "+teamName;
    }
}
