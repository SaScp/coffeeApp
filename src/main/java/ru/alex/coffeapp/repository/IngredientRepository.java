package ru.alex.coffeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.coffeapp.model.coffee.Ingredient;
import ru.alex.coffeapp.model.coffee.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("select ingr from Ingredient ingr where ingr.id in :ids")
    List<Ingredient> findAllByIds(@Param("ids") List<Integer> ids);


}
