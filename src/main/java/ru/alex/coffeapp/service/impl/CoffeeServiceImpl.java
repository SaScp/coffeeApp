package ru.alex.coffeapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.model.Coffee;
import ru.alex.coffeapp.model.Recipe;
import ru.alex.coffeapp.repository.CoffeeRepository;
import ru.alex.coffeapp.repository.IngredientRepository;
import ru.alex.coffeapp.repository.RecipeRepository;
import ru.alex.coffeapp.service.CoffeeService;


@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    private final ModelMapper modelMapper;

    @Override
    public Recipe save(RecipeIngredientsDto recipeIngredientsDto) {
        Recipe recipe = modelMapper.map(recipeIngredientsDto, Recipe.class);
        Coffee coffee = coffeeRepository.findById(recipeIngredientsDto.getCoffee()).orElseThrow();
        recipe.setCoffee(coffee);
        coffee.addRecipe(recipe);
        ingredientRepository.findAllByIds(recipeIngredientsDto.getIngredientsId());
        return recipeRepository.save(recipe);
    }
}
