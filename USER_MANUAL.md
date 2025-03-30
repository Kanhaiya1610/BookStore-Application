# BookStore Application - User Manual

## Welcome to BookStore! 

This guide will help you use our online bookstore application. You can browse books, search for specific titles, and manage your book collection.

## How to Access the Application

1. Open your web browser (Chrome, Firefox, etc.)
2. Enter this address: `http://your-ip-address:8080`
   - Your administrator will provide you with the correct IP address
   - Example: `http://192.168.1.100:8080`

## Getting Started

### Step 1: Register
1. Open this URL in your browser:
```
http://your-ip-address:8080/api/auth/signup
```
2. Fill in your details:
   - Username (at least 3 characters)
   - Email (must be valid format)
   - Password (at least 6 characters)
3. Click Submit

### Step 2: Login
1. Open this URL:
```
http://your-ip-address:8080/api/auth/signin
```
2. Enter your username and password
3. After successful login, you'll be redirected to the main page

## Using the Application

### View All Books
```
http://your-ip-address:8080/api/books
```
- Add `?page=0&size=10` to see first 10 books
- Change page number to see more books

### Search Books
1. By Title:
```
http://your-ip-address:8080/api/books/search?title=Harry Potter
```

2. By Author:
```
http://your-ip-address:8080/api/books/author/J.K. Rowling
```

3. By Category:
```
http://your-ip-address:8080/api/books/category/Fantasy
```

### Filter Books
To find books with specific criteria:
```
http://your-ip-address:8080/api/books/filter?category=Fantasy&minRating=4.5
```

## Tips for Using URLs
- Replace spaces with %20 in URLs
  - Instead of "Harry Potter", use "Harry%20Potter"
- Use correct spelling and capitalization
- Don't use special characters in search

## Common Issues

### Can't Access the Site
- Check your internet connection
- Verify the IP address with your administrator
- Make sure you're using the correct port number

### Search Not Working
- Check spelling
- Use simpler search terms
- Make sure you're logged in

### Login Issues
- Make sure caps lock is off
- Use correct username/password
- Contact admin if you forgot password

## Need Help?
Contact your administrator if you:
- Can't access the website
- Can't login
- See error messages
- Need to reset password

## Security Tips
1. Never share your password
2. Use a strong password
3. Don't use the application on public computers
4. Always logout when done

## For Remote Access
1. Make sure you have:
   - The correct website address
   - A stable internet connection
2. If you can't connect:
   - Check your internet
   - Contact your administrator

Remember: This is a secure application. If you can't access something, you might need to login first or contact your administrator for permissions.

## Special Section for Administrators

### Understanding User Roles
There are three types of roles in the system:
1. `ROLE_USER`: Can only view and search books
2. `ROLE_MODERATOR`: Can create and update books
3. `ROLE_ADMIN`: Full access (create, update, delete books and manage users)

### How to Create Users with Different Roles
1. **Create Regular User**:
```
http://your-ip-address:8080/api/auth/signup
```
Body:
```json
{
  "username": "normaluser",
  "email": "user@example.com",
  "password": "password123",
  "roles": ["user"]
}
```

2. **Create Moderator**:
```json
{
  "username": "moduser",
  "email": "mod@example.com",
  "password": "password123",
  "roles": ["mod"]
}
```

3. **Create Another Admin**:
```json
{
  "username": "adminuser",
  "email": "admin@example.com",
  "password": "password123",
  "roles": ["admin"]
}
```

4. **Create User with Multiple Roles**:
```json
{
  "username": "poweruser",
  "email": "power@example.com",
  "password": "password123",
  "roles": ["user", "mod"]
}
```

### Role Permissions
1. **ROLE_USER can**:
   - View all books
   - Search books
   - Filter books
   - View book details

2. **ROLE_MODERATOR can do everything ROLE_USER can, plus**:
   - Add new books
   - Update existing books
   - Manage book inventory

3. **ROLE_ADMIN can do everything ROLE_MODERATOR can, plus**:
   - Delete books
   - Manage users
   - View system logs

### Common Admin Tasks
1. **To upgrade a user to moderator**:
   - Create a new account with mod role
   - Share credentials with user

2. **To give full access**:
   - Create new account with admin role
   - Share credentials with user

3. **Best Practices**:
   - Create separate accounts for different roles
   - Don't share admin credentials
   - Regularly review user accounts
   - Remove access when no longer needed

### Security Guidelines for Admins
1. Always create users with minimum required roles
2. Regularly audit user accounts
3. Use strong passwords for admin accounts
4. Monitor system logs for suspicious activity
5. Keep the admin credentials secure 