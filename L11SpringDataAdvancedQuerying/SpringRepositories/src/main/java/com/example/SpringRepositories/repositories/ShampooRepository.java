package com.example.SpringRepositories.repositories;

import com.example.SpringRepositories.entities.Shampoo;
import com.example.SpringRepositories.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findByBrandAndSize(String brand, Size size);

    List<Shampoo> getAllBySizeOrderById(Size sizeValue);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long id);


    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query(value = "select s from Shampoo as s " +
            "join s.ingredients as i where i.name in :ingredientNames")
    List<Shampoo> findByIngredientNameIn(@Param(value = "ingredientNames") List<String> ingredientNames);


    @Query("UPDATE Shampoo AS s SET s.price = :newPrice WHERE s.id = :id")
    @Modifying
    void updatePriceById(BigDecimal newPrice, Long id);
}
