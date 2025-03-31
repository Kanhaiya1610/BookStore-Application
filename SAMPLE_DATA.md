# Sample Data for BookStore API

## User Accounts

### Admin User
```json
{
  "username": "admin123456",
  "email": "admin@example.com",
  "password": "ADMIN123456",
  "roles": ["ROLE_ADMIN"]
}
```

### Moderator User
```json
{
  "username": "moderator123456",
  "email": "moderator@example.com",
  "password": "MODERATOR123456",
  "roles": ["ROLE_MODERATOR"]
}
```

### Regular User
```json
{
  "username": "user123456",
  "email": "user@example.com",
  "password": "USER123456",
  "roles": ["ROLE_USER"]
}
```

## Sample Books

### Fiction Books
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565",
  "price": 9.99,
  "category": "Fiction",
  "description": "A story of decadence and excess, Gatsby explores the darker aspects of the Jazz Age.",
  "rating": 4.5
}
```

```json
{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "price": 12.99,
  "category": "Fiction",
  "description": "A dystopian social science fiction novel that examines the consequences of totalitarianism.",
  "rating": 4.8
}
```

### Non-Fiction Books
```json
{
  "title": "A Brief History of Time",
  "author": "Stephen Hawking",
  "isbn": "9780553380163",
  "price": 14.99,
  "category": "Non-Fiction",
  "description": "An exploration of modern physics and the universe's biggest mysteries.",
  "rating": 4.6
}
```

```json
{
  "title": "The Selfish Gene",
  "author": "Richard Dawkins",
  "isbn": "9780192860927",
  "price": 13.99,
  "category": "Non-Fiction",
  "description": "A study in evolutionary biology and the role of genes in natural selection.",
  "rating": 4.7
}
```

### Children's Books
```json
{
  "title": "Harry Potter and the Philosopher's Stone",
  "author": "J.K. Rowling",
  "isbn": "9780747532699",
  "price": 24.99,
  "category": "Children",
  "description": "The first book in the Harry Potter series, introducing the magical world of Hogwarts.",
  "rating": 4.9
}
```

```json
{
  "title": "The Very Hungry Caterpillar",
  "author": "Eric Carle",
  "isbn": "9780399226908",
  "price": 7.99,
  "category": "Children",
  "description": "A beloved children's book about a caterpillar's transformation into a butterfly.",
  "rating": 4.8
}
```

## API Test Data

### Authentication

#### Signin Request
```json
{
  "username": "admin123456",
  "password": "ADMIN123456"
}
```

#### Signup Request
```json
{
  "username": "newuser123",
  "email": "newuser@example.com",
  "password": "NEWUSER123456",
  "roles": ["ROLE_USER"]
}
```

### Book Operations

#### Create Book Request
```json
{
  "title": "New Book Title",
  "author": "New Author Name",
  "isbn": "9780123456789",
  "price": 19.99,
  "category": "Fiction",
  "description": "A new book description",
  "rating": 4.5
}
```

#### Update Book Request
```json
{
  "title": "Updated Book Title",
  "author": "Updated Author Name",
  "isbn": "9780123456789",
  "price": 24.99,
  "category": "Fiction",
  "description": "Updated book description",
  "rating": 4.7
}
```

## Test Headers

### Authorization Header
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMzQ1NiIsImlhdCI6MTcwOTg5MjQwMCwiZXhwIjoxNzA5OTc4ODAwfQ.YourJWTTokenHere
```

### Content-Type Header
```
Content-Type: application/json
```

## Test URLs

### Local Development
```
http://localhost:8080/swagger-ui.html
```

### Production
```
https://your-koyeb-app-url.com/swagger-ui.html
```

## Notes

1. All ISBNs are valid 13-digit numbers
2. Prices are in USD
3. Ratings are on a scale of 1-5
4. JWT tokens expire after 24 hours
5. All sample data is fictional and for testing purposes only 