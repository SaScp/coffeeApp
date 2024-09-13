package ru.alex.coffeapp.util.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.coffee.Recipe;
import ru.alex.coffeapp.repository.RecipeRepository;

@Component
public class RecipeValidator implements Validator {

    private final RecipeRepository recipeRepository;

    public RecipeValidator(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RecipeDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var recipe = (RecipeDto)target;
        if (recipeRepository.existsByName(recipe.getName())) {
            errors.rejectValue("name", "recipe.name.exists", "Recipe with this name already exists");
        }
    }
}
