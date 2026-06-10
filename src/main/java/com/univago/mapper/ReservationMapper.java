package com.univago.mapper;

import com.univago.dto.ReservationDto;
import com.univago.model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationDto dto);
    ReservationDto toDto(Reservation reservation);
}
