package com.bookstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
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
        description = "REST API for BookStore Application with JWT Authentication",
        contact = @Contact(
            name = "BookStore API Support",
            email = "support@bookstore.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0.html"
        )
    ),
    servers = {
        @Server(
            url = "https://curly-calla-kanhaiya1610-ddd176f1.koyeb.app/swagger-ui/index.html#/",
            description = "Production Server"
        ),
        @Server(
            url = "http://localhost:8080",
            description = "Local Development Server"
        )
    }
)
public class BookstoreApplication {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
