package com.spring.core.springcore;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run for 30minutes";
    }


}
