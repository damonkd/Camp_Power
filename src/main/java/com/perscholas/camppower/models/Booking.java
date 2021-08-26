package com.perscholas.camppower.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Slf4j

//@Table(name ="BOOKING")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String pickUpDate;

    @NotNull
    String returnDate;

    boolean pickedUp = false;

    boolean returned = false;

    boolean completed = false;

    @OneToOne()
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    Rentals rental;

    @OneToOne()
    @JoinColumn(name = "userRenter_id", referencedColumnName = "id")
    Users user;
}