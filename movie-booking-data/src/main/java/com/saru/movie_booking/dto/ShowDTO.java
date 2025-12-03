package com.saru.movie_booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowDTO {
    private long id;
    private TheaterDTO theater;
    private MovieDTO movie;
    private ScreenDTO screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;
}
