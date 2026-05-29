package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class SeatDTO {
    private long id;
    private Long screenId;
    private String seatNumber;
    private String seatType;
    private String status;
}
