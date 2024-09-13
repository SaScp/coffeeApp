package ru.alex.coffeapp.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.coffeapp.dto.RecipeIngredientsDto;
import ru.alex.coffeapp.service.CoffeeService;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    @Qualifier("coffeeServiceImpl")
    private final CoffeeService coffeeService;

    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public RecipeIngredientsDto save(@RequestBody RecipeIngredientsDto ingredientsDto) {
        return modelMapper.map(coffeeService.save(ingredientsDto), RecipeIngredientsDto.class);
    }
}
