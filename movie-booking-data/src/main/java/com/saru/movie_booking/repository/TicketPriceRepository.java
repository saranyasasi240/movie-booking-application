package com.saru.movie_booking.repository;

import com.saru.movie_booking.model.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {
    Optional<TicketPrice> findByShowIdAndSeatId(Long showId, Long seatId);
}
