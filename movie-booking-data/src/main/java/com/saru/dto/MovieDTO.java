package com.saru.dto;

import lombok.Data;

import java.time.Duration;

@Data
public class MovieDTO {
    private long id;
    private String title;
    private String genre;
    private String language;
    private Duration duration;
    private String rating;
}
