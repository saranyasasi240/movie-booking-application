package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.ScreenDTO;
import com.saru.movie_booking.mapper.ScreenMapper;
import com.saru.movie_booking.model.Screen;
import com.saru.movie_booking.repository.ScreenRepository;
import com.saru.movie_booking.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;
    private final ScreenMapper screenMapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, ScreenMapper screenMapper) {
        this.screenRepository = screenRepository;
        this.screenMapper = screenMapper;
    }

    @Override
    public ScreenDTO addScreen(ScreenDTO screenDTO) {
        Screen screen = screenMapper.toEntity(screenDTO);
        Screen savedScreen = screenRepository.save(screen);
        return screenMapper.toDTO(savedScreen);
    }

    @Override
    public List<ScreenDTO> getAllScreen() {
        List<ScreenDTO> allScreenDTO = new ArrayList<>();
        List<Screen> allScreens = screenRepository.findAll();
        for (Screen screen : allScreens) {
            allScreenDTO.add(screenMapper.toDTO(screen));
        }
        return allScreenDTO;
    }

    @Override
    public Optional<ScreenDTO> getScreenById(Long id) {
        Optional<Screen> screen = screenRepository.findById(id);
        ScreenDTO screenDTO = screenMapper.toDTO(screen.orElse(null));
        return Optional.ofNullable(screenDTO);
    }

    @Override
    public void deleteScreen(Long id) {
        screenRepository.deleteById(id);
    }
}
