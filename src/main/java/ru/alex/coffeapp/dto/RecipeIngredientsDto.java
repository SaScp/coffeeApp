package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.alex.coffeapp.model.Coffee;

import java.util.List;

@Data
public class RecipeIngredientsDto {

    private Integer id;

    private String name;

    private Integer quantityBuyers;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "coffeeType")
    private Long coffee;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> ingredientsId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<IngredientDto> ingredients;
}
