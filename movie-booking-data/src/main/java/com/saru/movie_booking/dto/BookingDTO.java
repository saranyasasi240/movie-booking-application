package com.saru.movie_booking.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingDTO {
    private long id;
    private Long userId;
    private Long showId;
    private List<Long> seatIds;
    private LocalDateTime bookingTime;
    private String status;
    private double totalPrice;
}

