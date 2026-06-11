package com.univago.mapper;

import com.univago.dto.PostDto;
import com.univago.dto.ReservationDto;
import com.univago.model.Location;
import com.univago.model.Post;
import com.univago.model.Reservation;
import com.univago.model.User;
import com.univago.repository.LocationRepository;
import com.univago.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReservationMapper {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Mapping(target = "guest", source = "guest")
    @Mapping(target = "location", source = "location")
    public abstract Reservation toEntity(ReservationDto dto);

    @Mapping(target = "guest", source = "guest.id")
    @Mapping(target = "location", source = "location.id")
    public abstract ReservationDto toDto(Reservation reservation);

    protected User mapGuest(Long guestId) {
        if (guestId == null) return null;
        return userRepository.findById(guestId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + guestId));
    }

    protected Location mapLocation(Long locationId) {
        if (locationId == null) return null;
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found: " + locationId));
    }
}
