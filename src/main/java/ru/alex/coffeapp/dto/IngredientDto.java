package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;


import java.util.List;

@Data
public class IngredientDto {

    private Long id;

    private String name;

    @JsonIgnore
    private List<RecipeIngredientsDto> recipeIngredients;

    private Integer count;
}
