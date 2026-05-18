package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.SeatDTO;
import com.saru.movie_booking.mapper.SeatMapper;
import com.saru.movie_booking.model.Seat;
import com.saru.movie_booking.repository.SeatRepository;
import com.saru.movie_booking.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    public SeatServiceImpl(SeatRepository seatRepository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
    }

    @Override
    public SeatDTO addSeat(SeatDTO seatDTO) {
        Seat seat = seatMapper.toEntity(seatDTO);
        Seat savedSeat = seatRepository.save(seat);
        return seatMapper.toDTO(savedSeat);
    }

    @Override
    public List<SeatDTO> getAllSeat() {
        List<SeatDTO> allSeatDTO = new ArrayList<>();
        List<Seat> allSeats = seatRepository.findAll();
        for (Seat seat : allSeats) {
            allSeatDTO.add(seatMapper.toDTO(seat));
        }
        return allSeatDTO;
    }

    @Override
    public Optional<SeatDTO> getSeatById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        SeatDTO seatDTO = seatMapper.toDTO(seat.orElse(null));
        return Optional.ofNullable(seatDTO);
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}
