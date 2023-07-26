package com.example.SpringRepositories.services;

import com.example.SpringRepositories.entities.Shampoo;
import com.example.SpringRepositories.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> getAllBySizeOrderById(Size sizeValue);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long id);

    List<Shampoo> findByPriceGreaterThan(BigDecimal price);

    int findCheaperThanCount(BigDecimal price);

    List<Shampoo> findAllWithIngredients(List<String> names);

    void save(Shampoo shampoo);

    void updatePriceForID(long id, BigDecimal newPrice);
}
