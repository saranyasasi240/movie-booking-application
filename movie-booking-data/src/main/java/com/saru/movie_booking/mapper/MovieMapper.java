package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.MovieDTO;
import com.saru.movie_booking.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO toDTO(Movie movie);
    Movie toEntity(MovieDTO movieDTO);
}
