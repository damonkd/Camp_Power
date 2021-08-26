package com.perscholas.camppower.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
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

//@Table(name ="IMAGES")
public class images implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String imageName;


    @ManyToOne(optional = false)
    @JoinColumn(name = "rentals_id")
    private Rentals rentals;

    public Rentals getRentals() {
        return rentals;
    }

    public void setRentals(Rentals rentals) {
        this.rentals = rentals;
    }
}