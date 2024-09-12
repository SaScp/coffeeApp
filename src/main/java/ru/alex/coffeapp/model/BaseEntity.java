package ru.alex.coffeapp.model;

public interface BaseEntity<T> {

    T getId();

    void setId(T t);
}
