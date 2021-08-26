package com.perscholas.camppower.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Slf4j

//@Table(name ="USERS")
public class Users implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String username;

    @NotNull
    String password;

    @Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    String role = "ROLE_USER";

    @Column(columnDefinition = "boolean default true")
    Boolean enabled = true;

    @Email
    @NotNull
    String email;

    @NotNull
    Integer zipCode;

    @NotNull
    String firstName;

    @NotNull
    String lastName;


    @OneToMany(mappedBy = "users")
    List<Rentals> rentList;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "booking_id")
    List<Booking> booking;

    public void setThisRentList(Rentals rental) {
        this.rentList.add(rental);
    }
}
