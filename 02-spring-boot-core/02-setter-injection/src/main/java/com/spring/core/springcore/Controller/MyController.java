package com.spring.core.springcore.Controller;


import com.spring.core.springcore.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private Coach c1;

//   Use Setter injection when you have optional dependencies
    @Autowired
    public void setCoach(Coach c1) {
        this.c1 = c1;
    }
    @GetMapping("/workout")
    public String getWorkout(){
        return c1.getDailyWorkout();
    }
}
