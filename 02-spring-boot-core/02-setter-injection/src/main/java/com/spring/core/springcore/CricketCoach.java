package com.spring.core.springcore;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run for 30minutes";
    }


}
