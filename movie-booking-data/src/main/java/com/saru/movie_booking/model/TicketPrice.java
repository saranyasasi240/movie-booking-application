package com.saru.movie_booking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_price")
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double price;

    @OneToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
