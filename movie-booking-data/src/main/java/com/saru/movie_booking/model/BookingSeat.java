package com.saru.movie_booking.model;

import jakarta.persistence.*;
import lombok.*;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "booking_seats")
public class BookingSeat {


    @JoinColumn(name = "booking_id")
    private Booking bookingId;

    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(name = "status")
    private String status;
}
