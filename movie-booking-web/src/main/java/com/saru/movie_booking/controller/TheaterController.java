package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.TheaterDTO;
import com.saru.movie_booking.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("/save")
    public ResponseEntity<TheaterDTO> addNewTheater(@RequestBody TheaterDTO theaterDTO) {
        TheaterDTO newTheater = theaterService.addTheater(theaterDTO);
        return ResponseEntity.ok(newTheater);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TheaterDTO>> getAllTheaters() {
        List<TheaterDTO> allTheaters = theaterService.getAllTheaters();
        return ResponseEntity.ok(allTheaters);
    }

    @GetMapping("/{id}")
    public TheaterDTO getById(@PathVariable Long id) {
        Optional<TheaterDTO> theaterDTO = theaterService.getTheaterById(id);
        return theaterDTO.orElseThrow(()->new RuntimeException("Theater not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id){
        theaterService.deleteTheater(id);
        return ResponseEntity.noContent().build();
    }
}
