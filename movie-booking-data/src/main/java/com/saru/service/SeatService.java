package com.saru.service;

import com.saru.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    Seat addSeat(Seat seat);

    List<Seat> getAllSeat();

    Optional<Seat> getSeatById(Long id);

    void deleteSeat(Long id);
}
