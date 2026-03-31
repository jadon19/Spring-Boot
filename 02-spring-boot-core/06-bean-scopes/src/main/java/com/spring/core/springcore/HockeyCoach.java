package com.spring.core.springcore;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HockeyCoach implements Coach {
    public HockeyCoach(){
        System.out.println("In constructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "walk for 30minutes";
    }
}

