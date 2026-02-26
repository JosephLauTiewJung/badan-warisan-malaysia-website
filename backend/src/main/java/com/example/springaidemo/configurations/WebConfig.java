package com.example.springaidemo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all paths
                .allowedOrigins("https://tcs-560362072194.europe-west1.run.app") // Allow all origins
                .allowedOrigins("http://localhost:5173") // Allow local development origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed actions
                .allowedHeaders("*"); // Allow all headers
    }
}
