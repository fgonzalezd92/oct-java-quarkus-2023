package com.herbalife.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "temperatures")
public class Temperature extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private String city;

    @Column
    private float temperature;

    @Column(name = "observation_date_time")
    private LocalDateTime observationDateTime;
}
