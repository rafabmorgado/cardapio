package com.example.cardapio.dtos;

import com.example.cardapio.entities.FoodEntity;
import com.example.cardapio.repositories.FoodRepository;

public record FoodResponseDTO(Long id, String title, String image, Integer price) {
    public FoodResponseDTO(FoodEntity food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
