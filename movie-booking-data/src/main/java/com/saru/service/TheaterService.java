package com.saru.service;

import com.saru.model.Theater;

import java.util.List;
import java.util.Optional;

public interface TheaterService {
    Theater addTheater(Theater theater);
    List<Theater> getAllTheaters();

    Optional<Theater> getTheaterById(Long id);

    void deleteTheater(Long id);
}
