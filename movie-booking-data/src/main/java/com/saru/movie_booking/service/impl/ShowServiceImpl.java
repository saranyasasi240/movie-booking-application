package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.ShowDTO;
import com.saru.movie_booking.mapper.ShowMapper;
import com.saru.movie_booking.model.Show;
import com.saru.movie_booking.repository.MovieRepository;
import com.saru.movie_booking.repository.ScreenRepository;
import com.saru.movie_booking.repository.ShowRepository;
import com.saru.movie_booking.repository.TheaterRepository;
import com.saru.movie_booking.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final TheaterRepository theaterRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;
    private final ShowMapper showMapper;

    public ShowServiceImpl(ShowRepository showRepository, ShowMapper showMapper,
                           TheaterRepository theaterRepository,MovieRepository movieRepository,
                           ScreenRepository screenRepository) {
        this.showRepository = showRepository;
        this.theaterRepository = theaterRepository;
        this.movieRepository = movieRepository;
        this.screenRepository = screenRepository;
        this.showMapper = showMapper;
    }

    @Override
    public ShowDTO addShow(ShowDTO showDTO) {
        Show show = showMapper.toEntity(showDTO);
        show.setTheater(theaterRepository.findById(showDTO.getTheaterId()).orElseThrow(()-> new RuntimeException("No theater found.!")));
        show.setMovie(movieRepository.findById(showDTO.getMovieId()).orElseThrow(()-> new RuntimeException("No movie found.!")));
        show.setScreen(screenRepository.findById(showDTO.getScreenId()).orElseThrow(()-> new RuntimeException("No screen found.!")));
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

    @Override
    public List<ShowDTO> searchByMovie(Long movieId) {
        return showRepository.findByMovie_Id(movieId)
                .stream().map(showMapper::toDTO).toList();
    }

    @Override
    public List<ShowDTO> searchByTheater(Long theaterId) {
        return showRepository.findByScreen_Theater_Id(theaterId)
                .stream().map(showMapper::toDTO).toList();
    }

    @Override
    public List<ShowDTO> searchByDate(String date) {
        return showRepository.findByStartTimeContaining(date)
                .stream().map(showMapper::toDTO).toList();
    }
}
