package com.practice.inventoryservice;

import com.practice.inventoryservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication implements CommandLineRunner {
    private final ProductService productService;

    public InventoryServiceApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        productService.populateDb();
        productService.findAll().forEach(System.out::println);
    }

}
