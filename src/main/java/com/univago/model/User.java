package com.univago.model;

import com.univago.model.util.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name= "users")
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

    public User(){}

    public User(Long id, String name, String email, String phone, String cpf, LocalDate dateOfBirth, Address address, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.passwordHash = passwordHash;
    }

    public User(Long id, String name, String email, String secondaryEmail, String phone, String secondaryPhone, String cpf, LocalDate dateOfBirth, Address address, String profileImage, String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.secondaryEmail = secondaryEmail;
        this.phone = phone;
        this.secondaryPhone = secondaryPhone;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.profileImage = profileImage;
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
