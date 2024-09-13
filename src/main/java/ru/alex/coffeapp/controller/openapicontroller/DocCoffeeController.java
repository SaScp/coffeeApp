package ru.alex.coffeapp.controller.openapicontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.dto.RecipeDto;
import ru.alex.coffeapp.model.entity.BuyingEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface DocCoffeeController {

    @Operation(responses = {
            @ApiResponse(responseCode = "200",
                    description = "Сохранение рецепта кофе",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RecipeDto.class)
                    )

            ),
            @ApiResponse(responseCode = "400",
                    description = "Возвращает 400 если не удалось сохранить рецепт",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)
                    )
            )
    }
    )
    public RecipeDto save(@Validated @RequestBody RecipeDto ingredientsDto, BindingResult bindingResult);

    @Operation(responses = {
            @ApiResponse(responseCode = "200",
                    description = "Выводит каталог кофе",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = List.class)
                    )

            )
    }
    )
    public CompletableFuture<List<CoffeeDto>> getCatalog();

    @Operation(responses = {
            @ApiResponse(responseCode = "200",
                    description = "Покупка кофе удалась",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BuyingEntity.class)
                    )

            ),
            @ApiResponse(responseCode = "400",
                    description = "Покупка не удалась",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)
                    )
            )
    }
    )
    public CompletableFuture<BuyingEntity> buy(@RequestParam("recipe-id") String id);

    @Operation(responses = {
            @ApiResponse(responseCode = "200",
                    description = "Выводит самый популярный рецепт кофе",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RecipeDto.class)
                    )

            )
    }
    )
    public CompletableFuture<RecipeDto> popular();
}
