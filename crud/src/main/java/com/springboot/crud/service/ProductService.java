package com.springboot.crud.service;

import com.springboot.crud.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int id);
    void deleteProduct(int id);
    Product createProduct(Product product, int catId);
    Product updateProduct(int id, Product product);
}
