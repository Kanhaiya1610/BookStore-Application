# BookStore API User Manual

## Introduction

Welcome to the BookStore API User Manual. This guide will help you understand how to use the BookStore API effectively. The API provides a secure and efficient way to manage books in a bookstore system.

## Getting Started

### 1. Accessing the API

1. Open your web browser
2. Go to `https://your-koyeb-app-url.com/swagger-ui.html`
3. You'll see the Swagger UI interface with all available APIs
4. The interface is organized by categories:
   - Authentication
   - Book Management
   - Admin Operations

### 2. User Registration

1. Click on the `/api/auth/signup` endpoint
2. Click "Try it out"
3. Enter your details:
```json
{
  "username": "your_username",
  "email": "your_email@example.com",
  "password": "your_password",
  "roles": ["ROLE_USER"]
}
```
4. Click "Execute"

**Important Notes:**
- Username must be 3-20 characters long
- Email must be valid and unique
- Password must be 6-40 characters long
- Role must be one of: "ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN"

### 3. User Login

1. Click on the `/api/auth/signin` endpoint
2. Click "Try it out"
3. Enter your credentials:
```json
{
  "username": "your_username",
  "password": "your_password"
}
```
4. Click "Execute"
5. Copy the JWT token from the response

**Security Tips:**
- Keep your password secure
- Don't share your JWT token
- Log out when done using the `/api/auth/signout` endpoint

### 4. Using the API

#### Authorizing Requests

1. Click the "Authorize" button at the top of the page
2. Enter: `Bearer your_jwt_token`
3. Click "Authorize"

#### Managing Books

##### Viewing Books

1. Click on the `/api/books` endpoint
2. Click "Try it out"
3. You can use these parameters:
   - `page`: Page number (default: 0)
   - `size`: Items per page (default: 10)
   - `sort`: Sort field and direction (e.g., "title,asc")
4. Click "Execute"

##### Searching Books

1. Click on the `/api/books/search` endpoint
2. Click "Try it out"
3. Enter search parameters:
   - `title`: Book title to search
   - `page`: Page number
   - `size`: Items per page
4. Click "Execute"

##### Filtering Books

1. Click on the `/api/books/filter` endpoint
2. Click "Try it out"
3. Enter filter parameters:
   - `author`: Filter by author
   - `category`: Filter by category
   - `minRating`: Minimum rating (0-5)
4. Click "Execute"

##### Adding a Book

1. Click on the `/api/books` endpoint
2. Click "Try it out"
3. Enter book details:
```json
{
  "title": "Book Title",
  "author": "Author Name",
  "isbn": "1234567890123",
  "price": 99.99,
  "category": "Fiction",
  "description": "Book Description",
  "rating": 4.5
}
```
4. Click "Execute"

**Validation Rules:**
- Title: Required, max 100 characters
- Author: Required, max 100 characters
- ISBN: Required, 13 digits
- Price: Required, must be positive
- Category: Required, max 50 characters
- Rating: Required, between 0-5

##### Updating a Book

1. Click on the `/api/books/{id}` endpoint
2. Click "Try it out"
3. Enter the book ID
4. Enter updated book details
5. Click "Execute"

##### Deleting a Book

1. Click on the `/api/books/{id}` endpoint
2. Click "Try it out"
3. Enter the book ID
4. Click "Execute"

## User Roles and Permissions

### Regular User (ROLE_USER)
- View all books
- Search books by title
- Filter books by:
  - Author
  - Category
  - Rating
- Cannot modify books

### Moderator (ROLE_MODERATOR)
- All USER permissions
- Create new books
- Update existing books
- Cannot delete books

### Administrator (ROLE_ADMIN)
- All MODERATOR permissions
- Delete books
- View all users
- Delete users
- Full system access

## Common Issues and Solutions

### 1. Authentication Issues

**Problem**: "Unauthorized" error
**Solution**: 
1. Make sure you're logged in
2. Check if your token is valid
3. Ensure you've added the token in the "Authorize" section
4. Try logging in again

**Problem**: "Token expired" error
**Solution**:
1. Log out using `/api/auth/signout`
2. Log in again to get a new token
3. Update the authorization header

### 2. Permission Issues

**Problem**: "Forbidden" error
**Solution**:
1. Check your user role
2. Ensure you have the required permissions
3. Contact your administrator for role upgrade
4. Try using a different endpoint that matches your role

### 3. Validation Issues

**Problem**: "Bad Request" error
**Solution**:
1. Check the error message for specific validation failures
2. Ensure all required fields are filled
3. Verify data formats:
   - ISBN: 13 digits
   - Price: Positive number
   - Rating: 0-5
   - Email: Valid format

### 4. Connection Issues

**Problem**: "Failed to fetch" error
**Solution**:
1. Check your internet connection
2. Verify the API URL is correct
3. Try refreshing the page
4. Clear browser cache
5. Check if the service is running

## Best Practices

### 1. Security
- Use strong passwords
- Don't share your JWT token
- Log out when done
- Use HTTPS for all requests
- Keep your browser updated

### 2. Data Entry
- Use valid ISBN numbers
- Enter prices in correct format
- Provide complete book details
- Use appropriate categories
- Give accurate ratings

### 3. Performance
- Use search and filter options
- Implement pagination for large datasets
- Cache frequently accessed data
- Use appropriate page sizes
- Sort data when needed

### 4. Error Handling
- Read error messages carefully
- Check validation rules
- Verify your permissions
- Try alternative approaches
- Report issues to administrators

## Support

If you encounter any issues:
1. Check the error message
2. Review the documentation
3. Try the common solutions
4. Contact your system administrator
5. Report bugs to the development team

## Updates

This manual will be updated as new features are added. Check regularly for updates. 