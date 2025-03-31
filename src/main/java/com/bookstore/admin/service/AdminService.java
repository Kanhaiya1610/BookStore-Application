package com.bookstore.admin.service;

import com.bookstore.admin.dto.UserDTO;
import java.util.List;

public interface AdminService {
    void deleteUser(String username);
    List<UserDTO> getAllUsers();
} 