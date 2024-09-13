package ru.alex.coffeapp.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.entity.BuyingEntity;
import ru.alex.coffeapp.service.CoffeeService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    @Qualifier("coffeeServiceImpl")
    private final CoffeeService coffeeService;

    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public RecipeDto save(@RequestBody RecipeDto ingredientsDto) {
        return modelMapper.map(coffeeService.save(ingredientsDto), RecipeDto.class);
    }
    @GetMapping("/catalog")
    public CompletableFuture<List<CoffeeDto>> getCatalog() {
        return coffeeService.findAll();
    }

    @PostMapping("/buy")
    public CompletableFuture<BuyingEntity> buy(@RequestParam("recipe-id") String id) {
        return coffeeService.buyCoffee(Long.parseLong(id));
    }

    @GetMapping("/popluar")
    public CompletableFuture<RecipeDto> popular() {
        return coffeeService.findPopularRecipe();
    }
}
