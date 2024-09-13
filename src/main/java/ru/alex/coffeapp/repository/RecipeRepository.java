package ru.alex.coffeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alex.coffeapp.model.coffee.Recipe;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "select recipe from Recipe recipe order by recipe.quantityBuyers DESC LIMIT 1")
    Optional<Recipe> findByQuantityBuyers();
}
