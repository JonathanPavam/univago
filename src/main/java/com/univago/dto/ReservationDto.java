package com.univago.dto;

import com.univago.model.Location;
import com.univago.model.User;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {
    private  User guest;
    private LocalDate date;
    private Location location;
}
