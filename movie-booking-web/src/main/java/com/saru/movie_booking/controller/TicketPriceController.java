package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.TicketPriceDTO;
import com.saru.movie_booking.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket-prices")
@RequiredArgsConstructor
public class TicketPriceController {

    private final TicketPriceService ticketPriceService;

    @PostMapping("/add")
    public ResponseEntity<TicketPriceDTO> addTicketPrice(@RequestBody TicketPriceDTO ticketPriceDTO) {
        return ResponseEntity.ok(ticketPriceService.addTicketPrice(ticketPriceDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketPriceDTO> updateTicketPrice(@PathVariable Long id, @RequestBody TicketPriceDTO ticketPriceDTO) {
        return ResponseEntity.ok(ticketPriceService.updateTicketPrice(id, ticketPriceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ticketPriceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<TicketPriceDTO> getTicketPrice(@RequestParam Long showId, @RequestParam Long seatId) {
        return ResponseEntity.ok(ticketPriceService.getTicketPrice(showId, seatId));
    }
}
