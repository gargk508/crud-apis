package com.springboot.crud.service.impl;

import com.springboot.crud.entity.Category;
import com.springboot.crud.entity.Product;
import com.springboot.crud.payload.ProductDto;
import com.springboot.crud.repository.CategoryRepository;
import com.springboot.crud.repository.ProductRepository;
import com.springboot.crud.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((prod)-> this.modelMapper.map(prod, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        return this.modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    @Override
    public ProductDto createProduct(ProductDto product, int catId) {
        Category category = categoryRepository.findById(catId).orElseThrow();
        Product prod = this.modelMapper.map(product, Product.class);
        prod.setCategory(category);
        Product addedProduct = productRepository.save(prod);
        return this.modelMapper.map(addedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto product) {
        Product prod = productRepository.findById(id).orElseThrow();
        prod.setProductName(product.getProductName());
        prod.setPrice(product.getPrice());
        Product updatedProduct = productRepository.save(prod);
        return this.modelMapper.map(updatedProduct, ProductDto.class);
    }
}
