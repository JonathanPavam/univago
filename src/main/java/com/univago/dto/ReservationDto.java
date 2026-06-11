package com.univago.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {
    private Long guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long location;
}
