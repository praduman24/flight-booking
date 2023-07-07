package com.example.flight_ticket_booking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("**")
                .allowedOrigins("*").allowedMethods("POST, GET, HEAD, OPTIONS, DELETE")
                .allowCredentials(true)
                .allowedHeaders("Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .maxAge(10);
    }

}