package ru.alex.coffeapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "recipe_ingredients", schema = "coffee_machine")
public class Ingredients implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Recipe> recipes;
}
