package ru.alex.coffeapp.service.impl;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.IngredientDto;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.coffee.Coffee;
import ru.alex.coffeapp.model.coffee.Ingredient;
import ru.alex.coffeapp.model.coffee.Recipe;
import ru.alex.coffeapp.model.entity.BuyingEntity;
import ru.alex.coffeapp.repository.CoffeeRepository;
import ru.alex.coffeapp.repository.IngredientRepository;
import ru.alex.coffeapp.repository.RecipeRepository;
import ru.alex.coffeapp.service.CoffeeService;
import ru.alex.coffeapp.util.exception.BuyCoffeeException;
import ru.alex.coffeapp.util.exception.SavedRecipeException;


import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    private final ModelMapper modelMapper;

    private final List<Validator> validator;

    @Override
    @Transactional
    public Recipe save(RecipeDto recipeDto, BindingResult bindingResult) {

        for (var v : validator)
            if (v.supports(RecipeDto.class)) {
                v.validate(recipeDto, bindingResult);
            }
        if (bindingResult.hasErrors()) {
            throw new SavedRecipeException("Recipe not saved because " + bindingResult.getFieldError().getDefaultMessage());
        }
        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
        Coffee coffee = coffeeRepository.findById(recipeDto.getCoffeeTypeId()).get();
        List<Ingredient> ingredients = ingredientRepository.findAllByIds(recipeDto.getIngredientsId());

        recipe.setCoffee(coffee);
        coffee.addRecipe(recipe);
        recipe.setIngredients(ingredients);

        for (var i : ingredients) {
            i.addRecipe(recipe);
        }

        return recipeRepository.save(recipe);
    }

    @Override
    public CompletableFuture<List<CoffeeDto>> findAll() {
        return CompletableFuture.supplyAsync(() ->
                coffeeRepository.findAll().stream()
                        .map(this::convertToCoffeeDto)
                        .collect(Collectors.toList())
        );
    }
    private CoffeeDto convertToCoffeeDto(Coffee entity) {
        CoffeeDto dto = modelMapper.map(entity, CoffeeDto.class);
        List<RecipeDto> recipeDtos = entity.getRecipes().stream()
                .map(this::convertToRecipeDto)
                .collect(Collectors.toList());
        dto.setRecipe(recipeDtos);
        return dto;
    }

    private RecipeDto convertToRecipeDto(Recipe entity) {
        RecipeDto dto = modelMapper.map(entity, RecipeDto.class);
        List<IngredientDto> ingredientDtos = entity.getIngredients().stream()
                .map(ingredient -> modelMapper.map(ingredient, IngredientDto.class))
                .collect(Collectors.toList());
        dto.setIngredients(ingredientDtos);
        return dto;
    }

    @Override
    public CompletableFuture<BuyingEntity> buyCoffee(Long recipeId) {
        return CompletableFuture.supplyAsync(() -> {
            Recipe recipe = recipeRepository.findById(recipeId).orElseThrow();

            if (isIngredientNotEqualsZero(recipe.getIngredients()))
                for (var i : recipe.getIngredients()) {
                    i.setCount(i.getCount() - 1);
                }
            else
                throw new BuyCoffeeException("Not enough ingredients to make coffee");

            recipe.setQuantityBuyers(recipe.getQuantityBuyers() + 1);
            recipeRepository.save(recipe);

            return new BuyingEntity(new Random().nextLong(10000000000L), recipe.getName(), UUID.randomUUID(), recipe.getCost());
        });
    }

    private boolean isIngredientNotEqualsZero(List<Ingredient> ingredients) {
        return ingredients.stream().noneMatch(ingredient -> ingredient.getCount() == 0);
    }

    @Override
    public CompletableFuture<RecipeDto> findPopularRecipe() {
        return CompletableFuture.supplyAsync(() -> {
                    Recipe recipe = recipeRepository.findByQuantityBuyers().orElseThrow();
                    RecipeDto map = modelMapper.map(recipe, RecipeDto.class);
                    return map;
                }
        );
    }

}
