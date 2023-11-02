package com.herbalife.examples;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    //WRONG
//    @Column(name = "person_id")
//    private int personId;
}
