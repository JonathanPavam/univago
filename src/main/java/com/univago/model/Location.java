package com.univago.model;

import com.univago.model.util.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private Long id;
    private String name;
    private Address address;
    private User owner;
    private String content;
}
