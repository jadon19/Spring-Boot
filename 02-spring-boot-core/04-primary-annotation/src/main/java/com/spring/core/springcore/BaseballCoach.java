package com.spring.core.springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "This is a primary implementation";
    }


}
