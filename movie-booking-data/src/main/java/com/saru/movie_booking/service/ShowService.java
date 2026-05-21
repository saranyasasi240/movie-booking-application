package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.ShowDTO;

import java.util.List;
import java.util.Optional;

public interface ShowService {

    ShowDTO addShow(ShowDTO showDTO);

    List<ShowDTO> getAllShow();

    Optional<ShowDTO> getShowById(Long id);

    void deleteShow(Long id);
}
