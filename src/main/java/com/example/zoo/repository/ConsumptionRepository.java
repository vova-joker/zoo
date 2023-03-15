package com.example.zoo.repository;

import com.example.zoo.entity.Consumption;
import com.example.zoo.entity.ConsumptionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, ConsumptionKey> {
}
