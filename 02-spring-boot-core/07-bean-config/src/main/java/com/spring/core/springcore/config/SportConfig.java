package com.spring.core.springcore.config;
import com.spring.core.springcore.Coach;
import com.spring.core.springcore.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
