package com.saru.movie_booking.repository;

import com.saru.movie_booking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScreen_IdAndStatus(Long screenId, String status);
}
