package com.bookstore.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class JwtConfig {
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    
    @Value("${app.jwtExpirationMs}")
    private long jwtExpirationMs;
} 