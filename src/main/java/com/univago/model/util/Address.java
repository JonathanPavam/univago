package com.univago.model.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String zipCode;
    private String country;
    private String state;
    private String city;
    private String street;
    private Integer number;
}
