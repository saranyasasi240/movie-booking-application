package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.ShowDTO;
import com.saru.movie_booking.model.Show;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, ScreenMapper.class})
public interface ShowMapper {
    ShowMapper INSTANCE = Mappers.getMapper(ShowMapper.class);

    ShowDTO toDTO(Show show);

    Show toEntity(ShowDTO showDTO);
}
