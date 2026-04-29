package com.spring.security.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {
    @Bean
    public JdbcUserDetailsManager users(DataSource ds){
        return new JdbcUserDetailsManager(ds);
    }
    @Bean
    public SecurityFilterChain myFilter(HttpSecurity http){
        http.authorizeHttpRequests(config->
                config.
                        requestMatchers(HttpMethod.GET,"/").permitAll()
                        .requestMatchers(HttpMethod.GET,"/manager").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
                        .requestMatchers("/employees/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(
                page->page.loginPage("/loginPage")
                                                        .loginProcessingUrl("/authenticateUser")
                                                        .usernameParameter("username")
                                                        .passwordParameter("password")
                                                        .defaultSuccessUrl("/dashboard")
                                                        .permitAll());
        http.logout(logout->logout.logoutSuccessUrl("/")
                .permitAll());
        http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
        return http.build();
    }
    @Bean
    public PasswordEncoder myEncoder(){
        return new BCryptPasswordEncoder();
    }
}
