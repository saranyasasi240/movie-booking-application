package com.saru.dto;

import lombok.Data;

@Data
public class SeatDTO {
    private long id;
    private ScreenDTO screen;
    private String seatNumber;
    private String seatType;
}
