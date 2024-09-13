package ru.alex.coffeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.coffeapp.model.coffee.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
