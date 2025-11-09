package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.model.Show;
import com.saru.movie_booking.repository.ShowRepository;
import com.saru.movie_booking.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public List<Show> getAllShow() {
        return showRepository.findAll();
    }

    @Override
    public Optional<Show> getShowById(Long id) {
        return showRepository.findById(id);
    }

    @Override
    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
