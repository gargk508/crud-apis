package com.springboot.crud.service.impl;

import com.springboot.crud.entity.Category;
import com.springboot.crud.entity.Product;
import com.springboot.crud.repository.CategoryRepository;
import com.springboot.crud.repository.ProductRepository;
import com.springboot.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    @Override
    public Product createProduct(Product product, int catId) {
        Category category = categoryRepository.findById(catId).orElseThrow();
        product.setCategory(category);
        Product addedProduct = productRepository.save(product);
        return addedProduct;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product prod = productRepository.findById(id).orElseThrow();
        prod.setCategory(product.getCategory());
        prod.setProductName(product.getProductName());
        prod.setPrice(product.getPrice());
        Product updatedProduct = productRepository.save(prod);
        return updatedProduct;
    }
}
