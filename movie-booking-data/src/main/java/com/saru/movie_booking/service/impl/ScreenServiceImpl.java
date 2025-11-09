package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.model.Screen;
import com.saru.movie_booking.repository.ScreenRepository;
import com.saru.movie_booking.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public Screen addScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public List<Screen> getAllScreen() {
        return screenRepository.findAll();
    }

    @Override
    public Optional<Screen> getScreenById(Long id) {
        return screenRepository.findById(id);
    }

    @Override
    public void deleteScreen(Long id) {
        screenRepository.deleteById(id);
    }
}
