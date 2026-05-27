package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.TicketPriceDTO;

import java.util.Optional;

public interface TicketPriceService {

    TicketPriceDTO addTicketPrice(TicketPriceDTO ticketPriceDTO);

    TicketPriceDTO updateTicketPrice(Long id, TicketPriceDTO ticketPriceDTO);

    void delete(Long id);

    TicketPriceDTO getTicketPrice(Long showId, Long seatId);
}
