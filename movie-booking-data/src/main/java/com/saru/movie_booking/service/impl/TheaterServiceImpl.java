package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.TheaterDTO;
import com.saru.movie_booking.mapper.TheaterMapper;
import com.saru.movie_booking.model.Theater;
import com.saru.movie_booking.repository.TheaterRepository;
import com.saru.movie_booking.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;

    public TheaterServiceImpl(TheaterRepository theaterRepository, TheaterMapper theaterMapper) {
        this.theaterRepository = theaterRepository;
        this.theaterMapper = theaterMapper;
    }

    @Override
    public TheaterDTO addTheater(TheaterDTO theaterDTO) {
        Theater theater = theaterMapper.toEntity(theaterDTO);
        Theater newTheater = theaterRepository.save(theater);
        return theaterMapper.toDTO(newTheater);
    }

    @Override
    public List<TheaterDTO> getAllTheaters() {
        List<TheaterDTO> allTheaterDTO = new ArrayList<>();
        List<Theater> allTheater = theaterRepository.findAll();
        for (Theater theater : allTheater) {
            allTheaterDTO.add(theaterMapper.toDTO(theater));
        }
        return allTheaterDTO;
    }

    @Override
    public Optional<TheaterDTO> getTheaterById(Long id) {
        Optional<Theater> theater = theaterRepository.findById(id);
        TheaterDTO theaterDTO = theaterMapper.toDTO(theater.orElse(null));
        return Optional.ofNullable(theaterDTO);
    }

    @Override
    public void deleteTheater(Long id) {
        theaterRepository.deleteById(id);
    }
}
