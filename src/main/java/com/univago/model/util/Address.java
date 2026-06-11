package com.univago.model.util;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {
    private String zipCode;
    private String country;
    private String state;
    private String city;
    private String street;
    private Integer number;
}
