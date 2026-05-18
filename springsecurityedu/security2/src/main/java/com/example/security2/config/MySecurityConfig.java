package com.example.security2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User.withUsername("duke")
                .password("{noop}1111")
                .authorities("ROLE_USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}

