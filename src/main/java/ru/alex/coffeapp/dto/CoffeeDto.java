package ru.alex.coffeapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CoffeeDto {

    private String nameType;

    private String instructions;

    private LocalDateTime prepTime;

    private Integer calories;

    private List<RecipeIngredientsDto> recipeIngredients;
}
