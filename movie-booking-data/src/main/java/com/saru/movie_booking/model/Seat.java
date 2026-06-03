package com.saru.movie_booking.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"screen_id", "seat_number"})
})
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "seat_type")
    private String seatType;

    @Column(name = "status")
    private String status;
}
