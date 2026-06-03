package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.SeatDTO;
import com.saru.movie_booking.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/add")
    public ResponseEntity<SeatDTO> addSeat(@RequestBody SeatDTO seatDTO) {
        SeatDTO newSeat = seatService.addSeat(seatDTO);
        return ResponseEntity.ok(newSeat);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        List<SeatDTO> listSeatDTO = seatService.getAllSeat();
        return ResponseEntity.ok(listSeatDTO);
    }

    @GetMapping("/{id}")
    public SeatDTO getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id).orElseThrow(() -> new RuntimeException("Seat not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<SeatDTO>> getAvailableSeatsByScreen(@RequestParam Long screenId) {
        return ResponseEntity.ok(seatService.getAvailableSeatsByScreen(screenId));
    }
}
