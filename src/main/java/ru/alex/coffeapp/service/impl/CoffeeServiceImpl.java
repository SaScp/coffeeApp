package ru.alex.coffeapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.model.Coffee;
import ru.alex.coffeapp.model.Recipe;
import ru.alex.coffeapp.repository.CoffeeRepository;
import ru.alex.coffeapp.repository.RecipeRepository;
import ru.alex.coffeapp.service.CoffeeService;
import ru.alex.coffeapp.util.RecipeMapper;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final RecipeRepository recipeRepository;

    @Override
    public CompletableFuture<Recipe> save(RecipeIngredientsDto recipeIngredientsDto) {

        return CompletableFuture.supplyAsync(() -> {
                    Recipe recipe = RecipeMapper.INSTANCE.recipeIngredientsDtoToRecipe(recipeIngredientsDto);
                    Coffee coffee = coffeeRepository.findById(recipeIngredientsDto.getCoffeeType()).orElseThrow();
                    recipe.setCoffee(coffee);
                    coffee.addRecipe(recipe);
                    return recipeRepository.save(recipe);
                }
        );
    }
}
