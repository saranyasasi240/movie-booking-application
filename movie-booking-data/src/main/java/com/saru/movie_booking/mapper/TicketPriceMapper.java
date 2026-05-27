package com.saru.movie_booking.mapper;

import com.saru.movie_booking.dto.TicketPriceDTO;
import com.saru.movie_booking.model.TicketPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketPriceMapper {

    TicketPriceMapper INSTANCE = Mappers.getMapper(TicketPriceMapper.class);

    @Mapping(source = "show.id", target = "showId")
    @Mapping(source = "seat.id", target = "seatId")
    TicketPriceDTO toDTO(TicketPrice ticketPrice);

    @Mapping(target = "show", ignore = true)
    @Mapping(target = "seat", ignore = true)
    TicketPrice toEntity(TicketPriceDTO ticketPriceDTO);
}
