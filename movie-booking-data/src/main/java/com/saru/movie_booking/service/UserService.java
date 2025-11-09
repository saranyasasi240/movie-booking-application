package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.UserDTO;
import com.saru.movie_booking.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteUser(Long id);
}
