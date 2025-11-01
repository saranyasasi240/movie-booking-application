package com.saru.service;

import com.saru.dto.UserDTO;
import com.saru.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteUser(Long id);
}
