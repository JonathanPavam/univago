package com.univago.mapper;

import com.univago.dto.ReservationDto;
import com.univago.model.Reservation;

public interface ReservationMapper {
    Reservation toEntity(ReservationDto dto);
    ReservationDto toDto(Reservation reservation);
}
