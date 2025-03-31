# BookStore API

A comprehensive Spring Boot REST API for managing a bookstore with JWT authentication, role-based access control, and Swagger documentation.

## Features

- 🔐 JWT Authentication with Cookie-based token storage
- 👥 Role-based Access Control (USER, MODERATOR, ADMIN)
- 📚 CRUD operations for Books with advanced filtering
- 📝 Swagger UI Documentation with OpenAPI 3.0
- 🗄️ PostgreSQL Database with JPA/Hibernate
- 🌐 CORS Support with configurable origins
- 🔧 Environment Variable Configuration
- 📊 Pagination support for all list operations
- 🔍 Advanced search and filtering capabilities
- ⚡ Exception handling with detailed error messages

## Tech Stack

- Java 17
- Spring Boot 3.2.3
- Spring Security with JWT
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger/OpenAPI 3.0
- Lombok
- JJWT (JSON Web Token)

## Project Structure

```
src/main/java/com/bookstore/
├── admin/           # Admin-specific operations
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/            # Data Transfer Objects
├── exception/      # Custom exceptions
├── model/          # Entity classes
├── repository/     # JPA repositories
├── security/       # Security configurations
└── service/        # Business logic
```

## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- PostgreSQL 12 or later
- Git

## Getting Started

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/bookstore-api.git
cd bookstore-api
```

2. **Configure Database**
- Create a PostgreSQL database
- Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Build the application**
```bash
mvn clean package
```

4. **Run the application**
```bash
java -jar target/bookstore-api-0.0.1-SNAPSHOT.jar
```

5. **Access Swagger UI**
- Open `http://localhost:8080/swagger-ui.html` in your browser

## API Documentation

### Authentication Endpoints

#### Signup
```http
POST /api/auth/signup
Content-Type: application/json

{
  "username": "admin123456",
  "email": "admin@example.com",
  "password": "ADMIN123456",
  "roles": ["ROLE_ADMIN"]
}
```

#### Signin
```http
POST /api/auth/signin
Content-Type: application/json

{
  "username": "admin123456",
  "password": "ADMIN123456"
}
```

### Book Endpoints

#### Create Book
```http
POST /api/books
Authorization: Bearer <jwt_token>
Content-Type: application/json

{
  "title": "Test Book",
  "author": "Test Author",
  "isbn": "1234567890123",
  "price": 99.99,
  "category": "Fiction",
  "description": "Test Description",
  "rating": 4.5
}
```

#### Get All Books (with pagination)
```http
GET /api/books?page=0&size=10&sort=title,asc
Authorization: Bearer <jwt_token>
```

#### Search Books
```http
GET /api/books/search?title=Harry&page=0&size=10
Authorization: Bearer <jwt_token>
```

#### Filter Books
```http
GET /api/books/filter?author=Rowling&category=Fiction&minRating=4.5
Authorization: Bearer <jwt_token>
```

### Admin Endpoints

#### Get All Users
```http
GET /api/admin/users
Authorization: Bearer <jwt_token>
```

#### Delete User
```http
DELETE /api/admin/users/{username}
Authorization: Bearer <jwt_token>
```

## Role-based Access Control

### Regular User (ROLE_USER)
- View all books
- Search books
- Filter books by various criteria
- Cannot modify books

### Moderator (ROLE_MODERATOR)
- All USER permissions
- Create new books
- Update existing books
- Cannot delete books

### Administrator (ROLE_ADMIN)
- All MODERATOR permissions
- Delete books
- Manage users (view and delete)
- Full system access

## Environment Variables

```properties
# Server Configuration
PORT=8080

# Database Configuration
DATABASE_URL=jdbc:postgresql://your-database-url:5432/your-database
DB_USERNAME=your-username
DB_PASSWORD=your-password

# JWT Configuration
JWT_SECRET=your-jwt-secret
JWT_EXPIRATION_MS=86400000

# CORS Configuration
CORS_ALLOWED_ORIGINS=*
```

## Security Features

- JWT-based authentication
- Password encryption with BCrypt
- Role-based authorization
- CORS protection
- Input validation
- Exception handling
- Secure cookie handling

## Error Handling

The API provides detailed error messages for:
- Authentication failures
- Authorization errors
- Resource not found
- Validation errors
- Bad requests
- Server errors

## Database Schema

### Users Table
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(120) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Books Table
```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) UNIQUE,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(50) NOT NULL,
    description TEXT,
    rating DECIMAL(3,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Deployment

1. **Build the application**
```bash
mvn clean package -DskipTests
```

2. **Deploy to Koyeb**
- Push to GitHub
- Connect repository to Koyeb
- Set environment variables in Koyeb dashboard
- Configure database connection
- Set up SSL certificates

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details. 