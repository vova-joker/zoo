package com.example.zoo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ConsumptionKey implements Serializable {

    @Column(name = "animal_id", insertable=false, updatable=false)
    Long animalId;

    @Column(name = "product_id",insertable=false, updatable=false)
    Long productId;

}
