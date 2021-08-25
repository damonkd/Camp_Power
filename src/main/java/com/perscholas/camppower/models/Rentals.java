package com.perscholas.camppower.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;





@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Slf4j

//@Table(name ="RENTALS")
public class Rentals implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String type;

    @NotNull
    String make;

    @NotNull
    Integer watts;

    @NotNull
    Integer locationZip;

    @NotNull
    float pricePerNight;

    @ManyToOne()
    @JoinColumn()
    Users user;





}
