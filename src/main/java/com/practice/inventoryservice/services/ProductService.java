package com.practice.inventoryservice.services;

import com.practice.inventoryservice.entities.Product;
import com.practice.inventoryservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void populateDb() {
        var random = new Random();
        var products = new ArrayList<Product>();

        for (int i = 0; i < 15; i++) {
            products.add(
                Product.builder()
                    .name("Product " + i)
                    .price(BigDecimal.valueOf(1200 + Math.random() * 10000).setScale(2, RoundingMode.HALF_UP))
                    .quantity(random.nextInt(200))
                    .build()
            );
        }
        productRepository.saveAll(products);
    }

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

}
