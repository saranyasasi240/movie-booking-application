package com.saru.movie_booking.service;

import com.saru.movie_booking.model.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService {
    Show addShow(Show show);

    List<Show> getAllShow();

    Optional<Show> getShowById(Long id);

    void deleteShow(Long id);
}
