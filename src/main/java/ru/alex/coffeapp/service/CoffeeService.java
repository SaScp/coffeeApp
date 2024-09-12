package ru.alex.coffeapp.service;

import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.model.Recipe;

import java.util.concurrent.CompletableFuture;

public interface CoffeeService {

    CompletableFuture<Recipe> save(RecipeIngredientsDto recipeIngredientsDto);
}
