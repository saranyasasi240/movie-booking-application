package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.BookingDTO;
import com.saru.movie_booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(bookingService.addBooking(bookingDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBooking());
    }

    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id).orElseThrow(() -> new RuntimeException("Booking not found..!"));
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
