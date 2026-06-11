package com.univago.dto;
import com.univago.model.util.Address;
import lombok.Data;

@Data
public class LocationDto {
    private String name;
    private Address address;
    private Long owner;
    private String content;
}
