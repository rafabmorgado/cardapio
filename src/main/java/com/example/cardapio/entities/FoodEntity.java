package com.example.cardapio.entities;
import com.example.cardapio.dtos.FoodRequestDTO;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public FoodEntity(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

    public void updateFood(FoodRequestDTO data){
        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.image() != null) {
            this.image = data.image();
        }

        if (data.price() != null) {
            this.price = data.price();
        }
    }
}
