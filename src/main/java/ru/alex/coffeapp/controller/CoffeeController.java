package ru.alex.coffeapp.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alex.coffeapp.controller.openapicontroller.DocCoffeeController;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.entity.BuyingEntity;
import ru.alex.coffeapp.service.CoffeeService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class CoffeeController implements DocCoffeeController {

    @Qualifier("coffeeServiceImpl")
    private final CoffeeService coffeeService;

    private final ModelMapper modelMapper;

    @PostMapping("/save")
    public RecipeDto save(@Validated @RequestBody RecipeDto ingredientsDto, BindingResult bindingResult) {
        return modelMapper.map(coffeeService.save(ingredientsDto, bindingResult), RecipeDto.class);
    }
    @GetMapping("/catalog")
    public CompletableFuture<List<CoffeeDto>> getCatalog() {
        return coffeeService.findAll();
    }

    @PostMapping("/buy")
    public CompletableFuture<BuyingEntity> buy(@RequestParam("recipe-id") String id) {
        return coffeeService.buyCoffee(Long.parseLong(id));
    }

    @GetMapping("/popular")
    public CompletableFuture<RecipeDto> popular() {
        return coffeeService.findPopularRecipe();
    }
}
