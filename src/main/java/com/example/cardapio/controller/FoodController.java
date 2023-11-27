package com.example.cardapio.controller;
import com.example.cardapio.dtos.FoodRequestDTO;
import com.example.cardapio.dtos.FoodResponseDTO;
import com.example.cardapio.entities.FoodEntity;
import com.example.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private  FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public  void saveFood(@RequestBody FoodRequestDTO data){
        FoodEntity foodData = new FoodEntity(data);
        repository.save(foodData);
        return;
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        return foodList;
    }
}
