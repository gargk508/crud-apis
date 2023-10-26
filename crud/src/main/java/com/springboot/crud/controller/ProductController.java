package com.springboot.crud.controller;

import com.springboot.crud.entity.Product;
import com.springboot.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/category/{catId}/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable int catId) {
        Product addedProduct = this.productService.createProduct(product, catId);
        return new ResponseEntity<Product>(addedProduct, HttpStatus.CREATED);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
        Product addedProduct = this.productService.updateProduct(id, product);
        return new ResponseEntity<Product>(addedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Product successfully deleted!!");
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = this.productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = this.productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
