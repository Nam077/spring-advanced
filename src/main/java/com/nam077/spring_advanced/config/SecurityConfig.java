package com.nam077.spring_advanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection if necessary
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().permitAll()  // Allow access to all endpoints without authentication
            );

        return http.build();
    }
}
