package com.univago.dto;

import com.univago.model.User;
import com.univago.model.util.Address;
import lombok.Data;

@Data
public class LocationDto {
    private String name;
    private Address address;
    private User owner;
    private String content;
}
