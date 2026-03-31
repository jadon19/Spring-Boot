package com.spring.core.springcore;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "walk for 30minutes";
    }
}
