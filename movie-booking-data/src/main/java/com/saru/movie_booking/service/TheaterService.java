package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.TheaterDTO;

import java.util.List;
import java.util.Optional;

public interface TheaterService {
    TheaterDTO addTheater(TheaterDTO theaterDTO);
    List<TheaterDTO> getAllTheaters();

    Optional<TheaterDTO> getTheaterById(Long id);

    void deleteTheater(Long id);
}
