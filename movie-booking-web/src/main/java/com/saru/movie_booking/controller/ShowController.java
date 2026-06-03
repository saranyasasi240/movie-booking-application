package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.ShowDTO;
import com.saru.movie_booking.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<ShowDTO> addShow(@RequestBody ShowDTO showDTO) {
        ShowDTO newShow = showService.addShow(showDTO);
        return ResponseEntity.ok(newShow);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ShowDTO>> getAllShows() {
        List<ShowDTO> listShowDTO = showService.getAllShow();
        return ResponseEntity.ok(listShowDTO);
    }

    @GetMapping("/{id}")
    public ShowDTO getShowById(@PathVariable Long id) {
        return showService.getShowById(id).orElseThrow(() -> new RuntimeException("Show not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        showService.deleteShow(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/movie")
    public ResponseEntity<List<ShowDTO>> searchByMovie(@RequestParam Long movieId) {
        return ResponseEntity.ok(showService.searchByMovie(movieId));
    }

    @GetMapping("/search/theater")
    public ResponseEntity<List<ShowDTO>> searchByTheater(@RequestParam Long theaterId) {
        return ResponseEntity.ok(showService.searchByTheater(theaterId));
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<ShowDTO>> searchByDate(@RequestParam String date) {
        return ResponseEntity.ok(showService.searchByDate(date));
    }
}
