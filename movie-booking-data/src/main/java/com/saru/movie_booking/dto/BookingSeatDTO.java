package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class BookingSeatDTO {
    private BookingDTO bookingId;
    private SeatDTO seat;
    private String status;
}
