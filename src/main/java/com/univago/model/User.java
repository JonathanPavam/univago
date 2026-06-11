package com.univago.model;
import com.univago.model.util.Address;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String secondaryEmail;
    private String phone;
    private String secondaryPhone;
    private String cpf;
    private LocalDate dateOfBirth;
    @Embedded
    private Address address;
    private String profileImage;
    private String passwordHash;

}
