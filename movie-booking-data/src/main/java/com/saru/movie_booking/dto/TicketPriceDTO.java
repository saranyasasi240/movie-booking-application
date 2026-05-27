package com.saru.movie_booking.dto;

import lombok.Data;

@Data
public class TicketPriceDTO {
    private long id;
    private double price;
    private Long showId;
    private Long seatId;
}
