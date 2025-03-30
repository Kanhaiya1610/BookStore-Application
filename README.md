# BookStore Management System

A Spring Boot-based RESTful API for managing a bookstore, featuring user authentication, role-based access control, and comprehensive book management capabilities.

## Features

- User Authentication (JWT-based)
- Role-Based Access Control (User, Moderator, Admin)
- Book Management (CRUD Operations)
- Advanced Book Filtering and Search
- Pagination and Sorting Support
- Swagger UI Documentation

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Security with JWT
- PostgreSQL
- Maven
- Swagger UI (OpenAPI)

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL
- Your favorite IDE (IntelliJ IDEA recommended)

## Setup Instructions

1. **Clone the Repository**
```bash
git clone <repository-url>
cd bookstore
```

2. **Database Setup**
```sql
CREATE DATABASE bookstore;
```

3. **Configure Application**
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. **Build and Run**
```bash
mvn clean install
mvn spring-boot:run
```

5. **Access Swagger UI**
```
http://localhost:8080/swagger-ui.html
```

## API Documentation

### Authentication APIs

1. **Register User**
- Endpoint: `POST /api/auth/signup`
- Description: Register new user with roles
- Access: Public
```json
{
  "username": "user123",
  "email": "user@example.com",
  "password": "password123",
  "roles": ["user"]
}
```

2. **Login**
- Endpoint: `POST /api/auth/signin`
- Description: Authenticate user and get JWT token
- Access: Public
```json
{
  "username": "user123",
  "password": "password123"
}
```

### Book Management APIs

1. **Create Book**
- Endpoint: `POST /api/books`
- Description: Add new book
- Access: ADMIN, MODERATOR
```json
{
  "title": "Book Title",
  "author": "Author Name",
  "category": "Category",
  "price": 299.99,
  "rating": 4.5,
  "publishedDate": "2024-03-29"
}
```

2. **Get All Books**
- Endpoint: `GET /api/books`
- Description: Get paginated list of books
- Access: All authenticated users
- Parameters: page, size, sort

3. **Get Book by ID**
- Endpoint: `GET /api/books/{id}`
- Description: Get specific book details
- Access: All authenticated users

4. **Update Book**
- Endpoint: `PUT /api/books/{id}`
- Description: Update existing book
- Access: ADMIN, MODERATOR

5. **Delete Book**
- Endpoint: `DELETE /api/books/{id}`
- Description: Delete book
- Access: ADMIN

### Search and Filter APIs

1. **Search Books**
- Endpoint: `GET /api/books/search`
- Description: Search books by title
- Parameter: title
- Access: All authenticated users

2. **Filter Books**
- Endpoint: `GET /api/books/filter`
- Description: Filter books by multiple criteria
- Parameters: author, category, minRating
- Access: All authenticated users

3. **Get Books by Category**
- Endpoint: `GET /api/books/category/{category}`
- Description: Get books by category
- Access: All authenticated users

4. **Get Books by Author**
- Endpoint: `GET /api/books/author/{author}`
- Description: Get books by author
- Access: All authenticated users

5. **Get Books by Rating**
- Endpoint: `GET /api/books/rating/{rating}`
- Description: Get books with rating >= specified value
- Access: All authenticated users

## Role-Based Access

- **ROLE_USER**: Can view books and use search/filter
- **ROLE_MODERATOR**: Can create and update books
- **ROLE_ADMIN**: Full access including deletion

## Testing Steps

1. **Create Admin User**
```json
{
  "username": "admin123",
  "email": "admin@example.com",
  "password": "admin123",
  "roles": ["admin"]
}
```

2. **Login and Get Token**
```json
{
  "username": "admin123",
  "password": "admin123"
}
```

3. **Use Token in Swagger UI**
- Click "Authorize" button
- Enter: Bearer <your_token>
- Test APIs

## Common Issues and Solutions

1. **JWT Token Issues**
- Ensure token is prefixed with "Bearer "
- Check token expiration
- Verify correct roles assigned

2. **Database Issues**
- Verify PostgreSQL is running
- Check database credentials
- Ensure tables are created

3. **Permission Issues**
- Verify user has correct roles
- Check JWT token includes required roles
- Ensure using admin token for privileged operations

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details 