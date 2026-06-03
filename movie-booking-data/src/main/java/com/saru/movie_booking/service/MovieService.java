package com.saru.movie_booking.service;

import com.saru.movie_booking.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    List<MovieDTO> getAllMovies();

    Optional<MovieDTO> getMovieById(Long id);

    void deleteMovie(Long id);

    List<MovieDTO> searchByTitle(String title);
    List<MovieDTO> searchByGenre(String genre);
    List<MovieDTO> searchByLanguage(String language);
}
