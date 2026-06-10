package com.univago.controller;

import com.univago.dto.LocationDto;
import com.univago.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocationDto> findbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(locationService.findById(id));
    }

    @RequestMapping
    public ResponseEntity<List<LocationDto>> findAll(){
        List<LocationDto> list = locationService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public ResponseEntity <LocationDto> post (@RequestBody LocationDto Location){
        return ResponseEntity.ok().body(locationService.create(Location));
    }

    @PutMapping("/{id}")
    public ResponseEntity <LocationDto> update (@PathVariable Long id,@RequestBody LocationDto dto){
        dto = locationService.put(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
