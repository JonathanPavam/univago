package com.univago.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
public class Reservation {
    private final Long id;
    private final User guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Location location;
}
