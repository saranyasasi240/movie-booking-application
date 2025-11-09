package com.saru.movie_booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "show_id")
    private Show shows;

    @Column(name="booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "status")
    private String status;

    @Column(name = "total_price")
    private double totalPrice;
}
