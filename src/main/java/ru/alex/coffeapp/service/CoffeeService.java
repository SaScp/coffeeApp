package ru.alex.coffeapp.service;

import org.springframework.validation.BindingResult;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.coffee.Recipe;
import ru.alex.coffeapp.model.entity.BuyingEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CoffeeService {

    Recipe save(RecipeDto recipeDto , BindingResult bindingResult);

    CompletableFuture<List<CoffeeDto>> findAll();

    CompletableFuture<BuyingEntity> buyCoffee(Long recipeId);

    CompletableFuture<RecipeDto> findPopularRecipe();
}
