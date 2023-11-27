package com.example.cardapio.repositories;

import com.example.cardapio.entities.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
