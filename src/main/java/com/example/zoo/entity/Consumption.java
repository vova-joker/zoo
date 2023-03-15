package com.example.zoo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "consumption")
@Data
public class Consumption {

    @EmbeddedId
    ConsumptionKey id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "animal_id", insertable = false, updatable = false)
    Animal animal;


    int standard;
}
