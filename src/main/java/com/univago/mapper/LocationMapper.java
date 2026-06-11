package com.univago.mapper;

import com.univago.dto.LocationDto;
import com.univago.model.Location;
import com.univago.model.User;
import com.univago.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LocationMapper {

    @Autowired
    private UserRepository userRepository;

    @Mapping(target = "owner", source = "owner")
    public abstract Location toEntity(LocationDto dto);

    @Mapping(target = "owner", source = "owner.id")
    public abstract LocationDto toDto(Location location);

    protected User mapOwner(Long ownerId) {
        if (ownerId == null) return null;
        return userRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + ownerId));
    }
}