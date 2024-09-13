package ru.alex.coffeapp.model.entity;

import java.util.UUID;

public record BuyingEntity(Long id, String nameProduct, UUID uniqueCode, Double sum) {
}
