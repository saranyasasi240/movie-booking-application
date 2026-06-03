package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.MovieDTO;
import com.saru.movie_booking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO newMovie = movieService.addMovie(movieDTO);
        return ResponseEntity.ok(newMovie);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> listMovieDTO = movieService.getAllMovies();
        return ResponseEntity.ok(listMovieDTO);
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id).orElseThrow(() -> new RuntimeException("Movie not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<MovieDTO>> searchByTitle(@RequestParam String title) {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/search/genre")
    public ResponseEntity<List<MovieDTO>> searchByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(movieService.searchByGenre(genre));
    }

    @GetMapping("/search/language")
    public ResponseEntity<List<MovieDTO>> searchByLanguage(@RequestParam String language) {
        return ResponseEntity.ok(movieService.searchByLanguage(language));
    }
}
