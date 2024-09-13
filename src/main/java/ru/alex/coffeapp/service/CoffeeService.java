package ru.alex.coffeapp.service;

import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.model.Recipe;

public interface CoffeeService {

    Recipe save(RecipeIngredientsDto recipeIngredientsDto);
}
