package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.MovieDTO;
import com.saru.movie_booking.mapper.MovieMapper;
import com.saru.movie_booking.model.Movie;
import com.saru.movie_booking.repository.MovieRepository;
import com.saru.movie_booking.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDTO(savedMovie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> allMovieDTO = new ArrayList<>();
        List<Movie> allMovie = movieRepository.findAll();
        for (Movie movie : allMovie) {
            allMovieDTO.add(movieMapper.toDTO(movie));
        }
        return allMovieDTO;
    }

    @Override
    public Optional<MovieDTO> getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        MovieDTO movieDTO = movieMapper.toDTO(movie.orElse(null));
        return Optional.ofNullable(movieDTO);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
