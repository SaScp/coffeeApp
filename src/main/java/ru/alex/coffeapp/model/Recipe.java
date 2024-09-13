package ru.alex.coffeapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "recipe")
public class Recipe implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name")
    @Size(max = 255)
    private String name;

    @Column(name = "quantity_buyers")
    private Integer quantityBuyers;

    @ManyToOne
    @JoinColumn(name = "coffee_id", referencedColumnName = "id")
    private Coffee coffee;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredients;
}
