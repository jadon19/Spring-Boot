package com.spring.core.springcore;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    public HockeyCoach(){
        System.out.println("In constructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "walk for 30minutes";
    }
}
