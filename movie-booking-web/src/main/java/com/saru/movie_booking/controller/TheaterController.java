package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.TheaterDTO;
import com.saru.movie_booking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<TheaterDTO> addTheater(@RequestBody TheaterDTO theaterDTO) {
        TheaterDTO newTheater = theaterService.addTheater(theaterDTO);
        return ResponseEntity.ok(newTheater);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TheaterDTO>> getAllTheaters() {
        List<TheaterDTO> listTheaterDTO = theaterService.getAllTheaters();
        return ResponseEntity.ok(listTheaterDTO);
    }

    @GetMapping("/{id}")
    public TheaterDTO getTheaterById(@PathVariable Long id) {
        return theaterService.getTheaterById(id).orElseThrow(() -> new RuntimeException("Theater not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
        return ResponseEntity.noContent().build();
    }
}
