package com.saru.movie_booking.service.impl;

import com.saru.movie_booking.dto.TicketPriceDTO;
import com.saru.movie_booking.mapper.TicketPriceMapper;
import com.saru.movie_booking.model.Seat;
import com.saru.movie_booking.model.Show;
import com.saru.movie_booking.model.TicketPrice;
import com.saru.movie_booking.repository.SeatRepository;
import com.saru.movie_booking.repository.ShowRepository;
import com.saru.movie_booking.repository.TicketPriceRepository;
import com.saru.movie_booking.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketPriceServiceImpl implements TicketPriceService {

    private final TicketPriceRepository ticketPriceRepository;
    private final TicketPriceMapper ticketPriceMapper;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    @Override
    public TicketPriceDTO addTicketPrice(TicketPriceDTO ticketPriceDTO) {
        if (ticketPriceRepository.findByShowIdAndSeatId(ticketPriceDTO.getShowId(), ticketPriceDTO.getSeatId()).isPresent()) {
            throw new RuntimeException("Ticket price already exists for this show and seat..!");
        }
        TicketPrice ticketPrice = ticketPriceMapper.toEntity(ticketPriceDTO);
        ticketPrice.setShow(resolveShow(ticketPriceDTO.getShowId()));
        ticketPrice.setSeat(resolveSeat(ticketPriceDTO.getSeatId()));
        return ticketPriceMapper.toDTO(ticketPriceRepository.save(ticketPrice));
    }

    @Override
    public TicketPriceDTO updateTicketPrice(Long id, TicketPriceDTO ticketPriceDTO) {
        TicketPrice existing = ticketPriceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TicketPrice not found..!"));
        existing.setPrice(ticketPriceDTO.getPrice());
        existing.setShow(resolveShow(ticketPriceDTO.getShowId()));
        existing.setSeat(resolveSeat(ticketPriceDTO.getSeatId()));
        return ticketPriceMapper.toDTO(ticketPriceRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        ticketPriceRepository.deleteById(id);
    }

    @Override
    public TicketPriceDTO getTicketPrice(Long showId, Long seatId) {
        TicketPrice ticketPrice = ticketPriceRepository.findByShowIdAndSeatId(showId, seatId)
                .orElseThrow(() -> new RuntimeException("TicketPrice not found..!"));
        return ticketPriceMapper.toDTO(ticketPrice);
    }

    private Show resolveShow(Long showId) {
        return showRepository.findById(showId).orElseThrow(() -> new RuntimeException("Show not found..!"));
    }

    private Seat resolveSeat(Long seatId) {
        return seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat not found..!"));
    }
}
