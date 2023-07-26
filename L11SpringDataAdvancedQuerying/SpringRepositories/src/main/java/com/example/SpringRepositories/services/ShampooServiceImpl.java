package com.example.SpringRepositories.services;

import com.example.SpringRepositories.entities.Shampoo;
import com.example.SpringRepositories.entities.Size;
import com.example.SpringRepositories.repositories.ShampooRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {
        return shampooRepository.findByBrand(brand);
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return shampooRepository.findByBrandAndSize(brand, size);
    }

    @Override
    public List<Shampoo> getAllBySizeOrderById(Size sizeValue) {
        return shampooRepository.getAllBySizeOrderById(sizeValue);
    }

    @Override
    public List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, long id) {
        return shampooRepository.findBySizeOrLabelIdOrderByPrice(size, id);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThan(BigDecimal price) {
        return shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int findCheaperThanCount(BigDecimal price) {
        return shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllWithIngredients(List<String> names) {
        return shampooRepository.findByIngredientNameIn(names);
    }

    @Override
    public void save(Shampoo shampoo) {
        shampooRepository.save(shampoo);
    }

    @Override
    @Transactional
    public void updatePriceForID(long id, BigDecimal newPrice) {
        shampooRepository.updatePriceById(newPrice,id);
    }
}
