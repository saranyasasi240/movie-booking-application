package com.saru.service.impl;

import com.saru.model.Movie;
import com.saru.repository.MovieRepository;
import com.saru.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    @Override
    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }
}
