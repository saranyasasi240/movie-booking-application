package com.saru.movie_booking.controller;


import com.saru.movie_booking.dto.UserDTO;
import com.saru.movie_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
