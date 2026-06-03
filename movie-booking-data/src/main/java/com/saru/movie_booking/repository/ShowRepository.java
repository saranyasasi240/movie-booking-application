package com.saru.movie_booking.repository;

import com.saru.movie_booking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovie_Id(Long movieId);
    List<Show> findByScreen_Theater_Id(Long theaterId);
    List<Show> findByStartTimeContaining(String date);
}
