package ru.alex.coffeapp.util.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alex.coffeapp.model.coffee.Coffee;
import ru.alex.coffeapp.repository.CoffeeRepository;

@Component
public class CoffeeValidator implements Validator {

    private final CoffeeRepository repository;

    public CoffeeValidator(CoffeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Coffee.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var id = (long) target;
        if (!repository.existsById(id)) {
            errors.rejectValue("id", "coffee.id.not.exists", "Coffee with this id not exists");
        }
    }
}
