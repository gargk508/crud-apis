package com.springboot.crud.repository;

import com.springboot.crud.entity.Category;
import com.springboot.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(Category category);
}
