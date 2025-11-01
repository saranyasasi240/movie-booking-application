package com.saru.mapper;

import com.saru.dto.MovieDTO;
import com.saru.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO toDTO(Movie movie);
    Movie toEntity(MovieDTO movieDTO);
}
