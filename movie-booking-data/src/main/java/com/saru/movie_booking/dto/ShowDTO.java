package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class ShowDTO {
    private long id;
    private Long theaterId;
    private Long movieId;
    private Long screenId;
    private String startTime;
    private String endTime;
    private double price;
}
