package com.example.cardapio.controller;
import com.example.cardapio.dtos.FoodRequestDTO;
import com.example.cardapio.dtos.FoodResponseDTO;
import com.example.cardapio.entities.FoodEntity;
import com.example.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private  FoodRepository repository;

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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFood(@PathVariable Long id, @RequestBody FoodRequestDTO data){
        Optional<FoodEntity> optionalFood = repository.findById(id);

        if (optionalFood.isPresent()) {
            FoodEntity existingFood = optionalFood.get();
            existingFood.updateFood(data);
            repository.save(existingFood);
            return new ResponseEntity<>("item atualizado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("item mão localizado", HttpStatus.BAD_REQUEST);
    }
}
