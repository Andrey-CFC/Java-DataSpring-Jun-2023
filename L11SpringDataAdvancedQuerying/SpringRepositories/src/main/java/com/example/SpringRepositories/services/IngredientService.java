package com.example.SpringRepositories.services;

import com.example.SpringRepositories.entities.Ingredient;

import java.util.List;

public interface IngredientService{

    List<Ingredient> findByName(String name);

    List<Ingredient> findByNameWithin(List<String> names);

    void increasePrice();

    void deleteIngredientsByName(String name);
}
