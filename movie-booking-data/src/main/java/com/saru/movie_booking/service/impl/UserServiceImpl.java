package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.UserDTO;
import com.saru.movie_booking.mapper.UserMapper;
import com.saru.movie_booking.model.User;
import com.saru.movie_booking.repository.UserRepository;
import com.saru.movie_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
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

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..!"));
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPhone(userDTO.getPhone());
        existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        existingUser.setRole(userDTO.getRole());
        return userMapper.toDTO(userRepository.save(existingUser));
    }
}
