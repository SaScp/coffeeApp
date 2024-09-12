package ru.alex.coffeapp.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.model.Coffee;
import ru.alex.coffeapp.model.Recipe;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe recipeIngredientsDtoToRecipe(RecipeIngredientsDto recipeIngredientsDto);
}
