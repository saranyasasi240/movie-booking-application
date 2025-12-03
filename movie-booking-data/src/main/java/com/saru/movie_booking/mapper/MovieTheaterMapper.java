package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.MovieTheaterDTO;
import com.saru.movie_booking.model.MovieTheater;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieTheaterMapper {
//    MovieTheaterMapper INSTANCE = Mappers.getMapper(MovieTheaterMapper.class);

    MovieTheaterDTO toDTO(MovieTheater movieTheater);
    MovieTheater toEntity(MovieTheaterDTO movieTheaterDTO);
}
