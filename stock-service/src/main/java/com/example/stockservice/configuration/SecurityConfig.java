package com.example.stockservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(
                                "/v3/api-docs/**",         // Swagger API docs
                                "/swagger-ui/**",          // Swagger UI
                                "/swagger-ui.html",        // Swagger UI HTML page
                                "/webjars/**" ,             // Webjars for Swagger
                                "/api/v1/stock/test"
                        ).permitAll()// Allow access to these endpoints
                        .anyRequest().permitAll())
                        .csrf(AbstractHttpConfigurer::disable);// Disable CSRF for API requests


        return http.build();
    }
}
