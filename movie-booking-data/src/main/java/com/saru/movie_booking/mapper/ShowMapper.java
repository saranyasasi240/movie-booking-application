package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.ShowDTO;
import com.saru.movie_booking.model.Show;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShowMapper {

    ShowMapper INSTANCE = Mappers.getMapper(ShowMapper.class);

    @Mapping(source = "theater.id", target = "theaterId")
    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "screen.id", target = "screenId")
    ShowDTO toDTO(Show show);

    @Mapping(target = "theater", ignore = true)
    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "screen", ignore = true)
    Show toEntity(ShowDTO showDTO);
}
