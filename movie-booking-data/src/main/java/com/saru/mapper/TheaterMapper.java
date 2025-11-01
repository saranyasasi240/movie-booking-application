package com.saru.mapper;

import com.saru.dto.TheaterDTO;
import com.saru.model.Theater;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ScreenMapper.class})
public interface TheaterMapper {
    TheaterMapper INSTANCE = Mappers.getMapper(TheaterMapper.class);

    TheaterDTO toDTO(Theater theater);

    Theater toEntity(TheaterDTO theaterDTO);
}
