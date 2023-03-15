package com.example.zoo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "type")
    String type;

    @Column(name = "is_predator")
    Boolean isPredator;//хищник

    @OneToMany(mappedBy = "animal")
    Set<Consumption> standard;
}
