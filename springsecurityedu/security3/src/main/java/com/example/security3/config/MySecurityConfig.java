package com.example.security3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                    .requestMatchers("/images/**", "/*.html").permitAll()
                    .anyRequest().authenticated() )
              .formLogin(Customizer.withDefaults());

        SecurityFilterChain chain = http.build();
        chain.getFilters().forEach(System.out::println);
        return chain;
    }
}
