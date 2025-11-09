package com.saru.movie_booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private long id;
    private UserDTO user;
    private ShowDTO shows;
    private LocalDateTime bookingTime;
    private String status;
    private double totalPrice;
}
