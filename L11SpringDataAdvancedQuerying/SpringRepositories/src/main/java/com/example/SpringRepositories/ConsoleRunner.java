package com.example.SpringRepositories;

import com.example.SpringRepositories.entities.Ingredient;
import com.example.SpringRepositories.entities.Shampoo;
import com.example.SpringRepositories.services.IngredientService;
import com.example.SpringRepositories.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Shampoo> byBrand = shampooService.findByBrand("Swiss Green Apple & Nettle");
//        List<Shampoo> byBrandAndSize = shampooService.findByBrandAndSize("Swiss Green Apple & Nettle", Size.SMALL);
//        byBrand.forEach(System.out::println);
//        byBrandAndSize.forEach(System.out::println);

//        List<Shampoo> allBySizeOrderById = shampooService.getAllBySizeOrderById(Size.LARGE);
//        allBySizeOrderById.forEach(System.out::println);

//        List<Shampoo> result = shampooService.findBySizeOrLabelIdOrderByPrice(Size.MEDIUM,10L);
//        List<Shampoo> result = shampooService.findByPriceGreaterThan(BigDecimal.valueOf(5));
//        List<Ingredient> result = ingredientService.findByName("M");

//        List<Ingredient> result = ingredientService.findByNameWithin(List.of("Lavender", "Herbs","Apple"));
//        List<Shampoo> result = shampooService.findAllWithIngredients(List.of("Berry","Mineral-Collagen"));
//        ingredientService.increasePrice();
//        ingredientService.deleteIngredientsByName("Apple");
//        result.forEach(System.out::println);
//        int count = shampooService.findCheaperThanCount(BigDecimal.valueOf(8.50));
//        System.out.println(count);

        Shampoo shampoo = shampooService.findByBrand("Swiss Green Apple & Nettle").get(0);
        shampoo.setPrice(BigDecimal.TEN);
        shampooService.save(shampoo);
        shampooService.updatePriceForID(1L, BigDecimal.valueOf(1L));

    }
}
