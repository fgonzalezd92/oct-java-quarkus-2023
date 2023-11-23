package com.herbalife.examples;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "cars")
@ToString(exclude = "owner")
public class Car {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person owner;


    //WRONG
//    @Column(name = "person_id")
//    private int personId;
}
