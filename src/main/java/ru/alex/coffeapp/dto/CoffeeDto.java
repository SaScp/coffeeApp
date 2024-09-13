package ru.alex.coffeapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Кофе", name = "Coffee")
public class CoffeeDto {

    @Schema(description = "Название кофе")
    private String nameType;

    @Schema(description = "Инструкция по приготовлению")
    private String instructions;

    @Schema(description = "Время приготовления")
    private LocalDateTime prepTime;

    @Schema(description = "Количество  калорий")
    private Integer calories;

    @Schema(description = "рецепты", implementation = RecipeDto.class)
    private List<RecipeDto> recipes;
}
