package ru.alex.coffeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.alex.coffeapp.model.Coffee;
import ru.alex.coffeapp.model.Ingredients;

import java.util.List;

@Data
public class RecipeIngredientsDto {

    private Integer id;

    private String name;

    private Integer quantityBuyers;

    @JsonIgnore
    private Coffee coffeeDto;

    private Long coffeeType;

    private List<Integer> ingredients;
}
