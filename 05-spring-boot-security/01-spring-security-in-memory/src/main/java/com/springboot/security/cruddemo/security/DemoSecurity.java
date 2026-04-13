package com.springboot.security.cruddemo.security;


import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

    @Bean
    public UserDetailsService users(){
        UserDetails user1 = User.builder()
                .username("tanishka")
                .password("{noop}tani123")
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.builder()
                .username("susan")
                .password("{noop}susan123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails user3 = User.builder()
                .username("moma")
                .password("{noop}moma123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
    
}
