package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.ScreenDTO;

import java.util.List;
import java.util.Optional;

public interface ScreenService {

    ScreenDTO addScreen(ScreenDTO screenDTO);

    List<ScreenDTO> getAllScreen();

    Optional<ScreenDTO> getScreenById(Long id);

    void deleteScreen(Long id);
}
