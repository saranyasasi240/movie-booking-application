package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.model.Theater;
import com.saru.movie_booking.repository.TheaterRepository;
import com.saru.movie_booking.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public Theater addTheater(Theater theater){
        return theaterRepository.save(theater);
    }

    @Override
    public List<Theater> getAllTheaters(){
        return theaterRepository.findAll();
    }

    @Override
    public Optional<Theater> getTheaterById(Long id){
        return theaterRepository.findById(id);
    }

    @Override
    public void deleteTheater(Long id){
        theaterRepository.deleteById(id);
    }
}
