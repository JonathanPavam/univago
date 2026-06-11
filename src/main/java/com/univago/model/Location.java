package com.univago.model;
import com.univago.model.util.Address;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Address address;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    private String content;
}
