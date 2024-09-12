package ru.alex.coffeapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "recipe_ingredients", schema = "coffee_machine")
public class RecipeIngredients implements BaseEntity<Coffee> {

    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Coffee id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private Ingredients ingredientsId;

    @Column(name = "quantity")
    @Size(max = 50)
    private String quantity;

    @Column(name = "buyers_count")
    private Integer buyersCount;
}
