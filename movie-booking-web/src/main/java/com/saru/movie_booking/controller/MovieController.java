package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.MovieDTO;
import com.saru.movie_booking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping(value = "/save")
    public ResponseEntity<MovieDTO> AddMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO newMovie = movieService.addMovie(movieDTO);
        return ResponseEntity.ok(newMovie);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieDTO>> GetAllMovies(){
        List<MovieDTO> listMovieDTO = movieService.getAllMovies();
        return ResponseEntity.ok(listMovieDTO);
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id).orElseThrow(()->new RuntimeException("Movie not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
