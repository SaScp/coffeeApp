package ru.alex.coffeapp.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CoffeeDto {

    private String nameType;

    private String instructions;

    private LocalDateTime prepTime;

    private Integer calories;

    private List<RecipeDto> recipe;
}
