package ru.alex.coffeapp.controller;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alex.coffeapp.util.exception.BuyCoffeeException;
import ru.alex.coffeapp.util.exception.SavedRecipeException;
import ru.alex.coffeapp.util.exception.handler.ExceptionHandlerStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private final Map<Class<? extends RuntimeException>, ExceptionHandlerStrategy> handlerStrategyMap;

    public GlobalControllerAdvice(List<ExceptionHandlerStrategy> strategies) {
        handlerStrategyMap = new HashMap<>();

        for (var strategy : strategies) {
            handlerStrategyMap.put(strategy.getExceptionClass(), strategy);
        }
    }

    @ExceptionHandler({BuyCoffeeException.class, SavedRecipeException.class})
    public ResponseEntity<ProblemDetail> ex(RuntimeException runtimeException) {
        var strategy = handlerStrategyMap.get(runtimeException.getClass()).execute(runtimeException);
        return ResponseEntity.status(strategy.getStatus())
                .body(strategy);
    }
}
