package com.bookstore.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .description("Please enter JWT token");

        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("bearer-jwt", securityScheme))
            .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"))
            .info(new Info()
                .title("BookStore API Documentation")
                .version("1.0")
                .description("Complete REST API documentation for BookStore Application"));
    }
} 