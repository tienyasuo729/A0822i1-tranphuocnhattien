package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
