package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {

    private Integer id;

    private String name;

    @JsonIgnore
    private Integer quantityBuyers;

    private Double cost;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "coffeeType")
    private Long coffeeTypeId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> ingredientsId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<IngredientDto> ingredients;
}
