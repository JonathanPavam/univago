package com.univago.service;

import com.univago.dto.LocationDto;
import com.univago.mapper.LocationMapper;
import com.univago.model.Location;
import com.univago.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;


    public LocationDto create (LocationDto dto){
        Location location = locationMapper.toEntity(dto);
        location = locationRepository.save(location);
        return locationMapper.toDto(location);
    }

    public LocationDto put (Long id, LocationDto dto){
        Location location = locationRepository.findById(id).orElseThrow();
        dtoToEntity(location, dto);
        location = locationRepository.save(location);
        return locationMapper.toDto(location);
    }

    public List<LocationDto> findALl(){
        return locationRepository.findAll().stream().map(locationMapper::toDto).collect(Collectors.toList());
    }

    public LocationDto findById(Long id){
        return locationRepository.findById(id).map(locationMapper::toDto).orElseThrow();
    }

    public void delete(Long id){
        locationRepository.deleteById(id);
    }

    public void dtoToEntity (Location entity, LocationDto dto){
        entity.setContent(dto.getContent());
        entity.setName(dto.getName());
    }
}
