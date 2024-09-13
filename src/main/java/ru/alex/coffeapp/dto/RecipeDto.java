package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Рецепт", name = "Recipe")
public class RecipeDto {

    @Schema(description = "Идентификатор рецепта")
    private Integer id;

    @Schema(description = "Название рецепта")
    private String name;

    @JsonIgnore
    private Integer quantityBuyers;

    @Schema(description = "Стоимость рецепта")
    private Double cost;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "coffeeType")
    @Schema(description = "Идентификатор типа кофе")
    private Long coffeeTypeId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Schema(description = "Идентификаторы ингредиентов", implementation = List.class)
    private List<Integer> ingredientsId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Ингредиенты", implementation = IngredientDto.class)
    private List<IngredientDto> ingredients;
}
