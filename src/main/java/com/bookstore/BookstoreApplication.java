package com.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(
    info = @Info(
        title = "BookStore API Documentation",
        version = "1.0",
        description = "Complete REST API documentation for BookStore Application",
        contact = @Contact(
            name = "BookStore API Support",
            email = "agarwalkanhaiya070@gmail.com"
        )
    )
)
@SecurityScheme(
    name = "bearer-jwt",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "JWT token authentication"
)
public class BookstoreApplication {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
