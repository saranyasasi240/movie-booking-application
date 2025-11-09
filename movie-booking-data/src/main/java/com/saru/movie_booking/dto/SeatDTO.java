package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class SeatDTO {
    private long id;
    private ScreenDTO screen;
    private String seatNumber;
    private String seatType;
}
