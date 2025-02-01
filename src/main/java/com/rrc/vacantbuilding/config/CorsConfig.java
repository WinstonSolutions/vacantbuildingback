package com.rrc.vacantbuilding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration  // Marks this as a configuration class
public class CorsConfig {
    
    @Bean  // Creates a bean that Spring will manage
    public CorsFilter corsFilter() {
        // Create new CORS configuration
        CorsConfiguration config = new CorsConfiguration();
        
        // Allow Vercel deployment
        config.addAllowedOriginPattern("https://*.vercel.app");
        // Allow local development environments
        config.addAllowedOriginPattern("http://localhost:[*]");
        config.addAllowedOriginPattern("http://127.0.0.1:[*]");
        
        // Allow credentials (cookies, authorization headers, etc.)
        config.setAllowCredentials(true);
        
        // Allow all common HTTP methods
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        
        // Allow all headers
        config.addAllowedHeader("*");
        
        // Set how long the browser should cache CORS response (in seconds)
        config.setMaxAge(3600L);
        
        // Create source for URL-based CORS configuration
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply CORS configuration to all paths
        source.registerCorsConfiguration("/**", config);
        
        // Create and return the CORS filter
        return new CorsFilter(source);
    }
} 