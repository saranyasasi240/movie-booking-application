package com.saru.movie_booking.repository;

import com.saru.movie_booking.model.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {

    List<BookingSeat> findByBooking_Id(Long bookingId);

    List<BookingSeat> findBySeat_Id(Long seatId);
}
