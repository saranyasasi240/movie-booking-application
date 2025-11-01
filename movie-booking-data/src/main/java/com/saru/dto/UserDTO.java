package com.saru.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private List<BookingDTO> bookings;
}
