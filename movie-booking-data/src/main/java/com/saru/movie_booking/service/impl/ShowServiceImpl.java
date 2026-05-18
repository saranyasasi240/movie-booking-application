package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.ShowDTO;
import com.saru.movie_booking.mapper.ShowMapper;
import com.saru.movie_booking.model.Show;
import com.saru.movie_booking.repository.ShowRepository;
import com.saru.movie_booking.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final ShowMapper showMapper;

    public ShowServiceImpl(ShowRepository showRepository, ShowMapper showMapper) {
        this.showRepository = showRepository;
        this.showMapper = showMapper;
    }

    @Override
    public ShowDTO addShow(ShowDTO showDTO) {
        Show show = showMapper.toEntity(showDTO);
        Show savedShow = showRepository.save(show);
        return showMapper.toDTO(savedShow);
    }

    @Override
    public List<ShowDTO> getAllShow() {
        List<ShowDTO> allShowDTO = new ArrayList<>();
        List<Show> allShows = showRepository.findAll();
        for (Show show : allShows) {
            allShowDTO.add(showMapper.toDTO(show));
        }
        return allShowDTO;
    }

    @Override
    public Optional<ShowDTO> getShowById(Long id) {
        Optional<Show> show = showRepository.findById(id);
        ShowDTO showDTO = showMapper.toDTO(show.orElse(null));
        return Optional.ofNullable(showDTO);
    }

    @Override
    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
