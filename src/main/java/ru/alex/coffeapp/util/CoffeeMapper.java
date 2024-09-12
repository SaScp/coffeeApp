package ru.alex.coffeapp.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.alex.coffeapp.dto.CoffeeDto;
import ru.alex.coffeapp.model.Coffee;
@Mapper
public interface CoffeeMapper {

    CoffeeMapper INSTANCE = Mappers.getMapper(CoffeeMapper.class);

    Coffee coffeeDtoToCoffee(CoffeeDto coffeeDto);
}
