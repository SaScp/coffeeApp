package ru.alex.coffeapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "t_coffee", schema = "coffee_machine")
public class Coffee implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 128)
    @Column(name = "name_type", unique = true, nullable = false)
    private String nameType;


    @Column(name = "instructions", nullable = false)
    private String instructions;

    @Column(name = "prep_time", nullable = false)
    private LocalDateTime prepTime;

    @Column(name = "calories")
    private Integer calories;

    @OneToMany(mappedBy = "coffee")
    private List<Recipe> recipes = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
