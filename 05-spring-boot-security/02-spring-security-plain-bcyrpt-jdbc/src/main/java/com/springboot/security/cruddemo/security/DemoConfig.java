package com.springboot.security.cruddemo.security;

import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {
    @Bean
    public SecurityFilterChain myChain(HttpSecurity http)  {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET,"/api/employees/*").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PATCH,"/api/employees/*").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE,"/api/employees/*").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic(config->{});
    return http.build();

    }
}
