package com.example.SpringRepositories.services;

import com.example.SpringRepositories.entities.Ingredient;
import com.example.SpringRepositories.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByName(String name) {
        return ingredientRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> findByNameWithin(List<String> names) {
        return ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    public void increasePrice() {
        ingredientRepository.increasePriceBy10Percent();
    }

    @Override
    public void deleteIngredientsByName(String name) {
        ingredientRepository.deleteIngredientsByName(name);
    }
}
