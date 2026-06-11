package com.univago.service;
import com.univago.dto.ReservationDto;
import com.univago.mapper.ReservationMapper;
import com.univago.model.Reservation;
import com.univago.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository ReservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public ReservationDto create (ReservationDto dto){
        Reservation reservation = reservationMapper.toEntity(dto);
        reservation = ReservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public ReservationDto put (Long id, ReservationDto dto){
        Reservation reservation = ReservationRepository.findById(id).orElseThrow();
        dtoToEntity(reservation, dto);
        reservation = ReservationRepository.save(reservation);
        return reservationMapper.toDto(reservation);
    }

    public List<ReservationDto> findALl(){
        return ReservationRepository.findAll().stream().map(reservationMapper::toDto).collect(Collectors.toList());
    }

    public ReservationDto findById(Long id){
        return ReservationRepository.findById(id).map(reservationMapper::toDto).orElseThrow();
    }

    public void delete(Long id){
        ReservationRepository.deleteById(id);
    }

    public void dtoToEntity (Reservation entity, ReservationDto dto){
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
    }
}
