package com.saru.dto;

import lombok.Data;

import java.util.List;

@Data
public class TheaterDTO {
    private long id;
    private String name;
    private String city;
    private String address;
    private List<ScreenDTO> screens;
}
