package com.spring.core.springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("In constructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "This is a primary implementation";
    }


}
