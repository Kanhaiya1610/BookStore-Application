package com.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(
    info = @Info(
        title = "BookStore API",
        version = "1.0",
        description = "REST API for BookStore Application"
    )
)
public class BookstoreApplication {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
