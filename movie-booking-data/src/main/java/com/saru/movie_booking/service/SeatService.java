package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.SeatDTO;

import java.util.List;
import java.util.Optional;

public interface SeatService {

    SeatDTO addSeat(SeatDTO seatDTO);

    List<SeatDTO> getAllSeat();

    Optional<SeatDTO> getSeatById(Long id);

    void deleteSeat(Long id);

    List<SeatDTO> getAvailableSeatsByScreen(Long screenId);
}
