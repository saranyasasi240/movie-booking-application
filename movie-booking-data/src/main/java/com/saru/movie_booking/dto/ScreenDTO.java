package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class ScreenDTO {
    private long id;
    private TheaterDTO theater;
    private String screenNumber;
    private String totalSeats;
}
