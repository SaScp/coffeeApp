package ru.alex.coffeapp.util.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import ru.alex.coffeapp.util.exception.SavedRecipeException;

@Component
public class SavedExceptionHandler implements ExceptionHandlerStrategy {
    @Override
    public ProblemDetail execute(RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @Override
    public Class<? extends RuntimeException> getExceptionClass() {
        return SavedRecipeException.class;
    }
}
