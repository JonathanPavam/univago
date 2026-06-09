package com.univago.mapper;

import com.univago.dto.LocationDto;
import com.univago.model.Location;

public interface LocationMapper {
    Location toEntity(LocationDto dto);
    LocationDto toDto(Location location);
}
