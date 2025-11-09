package com.saru.movie_booking.service;

import com.saru.movie_booking.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie addMovie(Movie movie);

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(Long id);

    void deleteMovie(Long id);
}
