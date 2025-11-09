package com.saru.movie_booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String genre;
    private String language;
    private Duration duration;
    private String rating;
}
