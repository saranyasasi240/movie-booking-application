package com.saru.movie_booking.controller;


import com.saru.movie_booking.dto.UserDTO;
import com.saru.movie_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> UserRegistration(@RequestBody UserDTO userDTO) {
        UserDTO newUser = userService.addUser(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> GetAllUsers(){
        List<UserDTO> listUserDTO = userService.getAllUsers();
        return ResponseEntity.ok(listUserDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id).orElseThrow(()->new RuntimeException("User not found..!"));
    }

    @PutMapping("/update")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
