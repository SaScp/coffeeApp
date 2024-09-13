package ru.alex.coffeapp.model.entity;

public interface BaseEntity<T> {

    T getId();

    void setId(T t);
}
