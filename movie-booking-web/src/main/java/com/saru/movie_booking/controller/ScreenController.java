package com.saru.movie_booking.controller;

import com.saru.movie_booking.dto.ScreenDTO;
import com.saru.movie_booking.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping("/add")
    public ResponseEntity<ScreenDTO> addScreen(@RequestBody ScreenDTO screenDTO) {
        ScreenDTO newScreen = screenService.addScreen(screenDTO);
        return ResponseEntity.ok(newScreen);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ScreenDTO>> getAllScreens() {
        List<ScreenDTO> listScreenDTO = screenService.getAllScreen();
        return ResponseEntity.ok(listScreenDTO);
    }

    @GetMapping("/{id}")
    public ScreenDTO getScreenById(@PathVariable Long id) {
        return screenService.getScreenById(id).orElseThrow(() -> new RuntimeException("Screen not found..!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Long id) {
        screenService.deleteScreen(id);
        return ResponseEntity.noContent().build();
    }
}
