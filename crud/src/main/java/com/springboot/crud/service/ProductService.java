package com.springboot.crud.service;

import com.springboot.crud.payload.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    ProductDto getProductById(int id);
    void deleteProduct(int id);
    ProductDto createProduct(ProductDto product, int catId);
    ProductDto updateProduct(int id, ProductDto product);
}
