package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;


import java.util.List;

@Data
@Schema(description = "Ингредиент", name = "Ingredient")
public class IngredientDto {

    @Schema(description = "Идентификатор ингредиента")
    private Long id;

    @Schema(description = "Название ингредиента")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> recipeIngredients;

    @Schema(description = "Количество ингредиента")
    private Integer count;
}
