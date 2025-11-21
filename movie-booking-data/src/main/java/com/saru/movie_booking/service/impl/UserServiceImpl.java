package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.UserDTO;
import com.saru.movie_booking.mapper.UserMapper;
import com.saru.movie_booking.model.User;
import com.saru.movie_booking.repository.UserRepository;
import com.saru.movie_booking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> allUserDTO = new ArrayList<>();
        List<User> allUser = userRepository.findAll();
        for (User user : allUser) {
            allUserDTO.add(userMapper.toDTO(user));
        }
        return allUserDTO;
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDTO userDTO = userMapper.toDTO(user.orElse(null));
        return Optional.ofNullable(userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
