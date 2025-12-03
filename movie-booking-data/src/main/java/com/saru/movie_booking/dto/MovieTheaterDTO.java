package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class MovieTheaterDTO {
    private long id;
    private MovieDTO movie;
    private TheaterDTO theater;
}
