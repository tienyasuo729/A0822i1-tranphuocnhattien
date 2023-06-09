package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> list;

    static {
        list = new ArrayList<>();
        list.add(new Product(1, "Ao", 10, 150));
        list.add(new Product(2, "Quan", 11, 250));
        list.add(new Product(3, "Giay", 12, 350));
        list.add(new Product(4, "Mu", 13, 50));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        for (Product product : list) {
            if (Objects.equals(product.getId(), id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public void remove(Long id) {
        list.removeIf(product -> Objects.equals(product.getId(), id));
//        for (Product product : list) {
//            if (Objects.equals(product.getId(), id)) {
//                list.remove(product);
//            }
//        }
    }
}
