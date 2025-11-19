package com.saru.movie_booking.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String phone;
}
