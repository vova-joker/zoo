package com.example.zoo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", unique = true)
    String name;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "measure")
    String measure;

    @Column(name = "type")
    String type;

    @OneToMany(mappedBy = "product")
    Set<Consumption> standard;
}
