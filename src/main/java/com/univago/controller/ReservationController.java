package com.univago.controller;

import com.univago.dto.ReservationDto;
import com.univago.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReservationDto> findbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(reservationService.findById(id));
    }

    @RequestMapping
    public ResponseEntity<List<ReservationDto>> findAll(){
        List<ReservationDto> list = reservationService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public ResponseEntity <ReservationDto> post (@RequestBody ReservationDto Reservation){
        return ResponseEntity.ok().body(reservationService.create(Reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity <ReservationDto> update (@PathVariable Long id,@RequestBody ReservationDto dto){
        dto = reservationService.put(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
