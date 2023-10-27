package com.springboot.crud.controller;

import com.springboot.crud.payload.ProductDto;
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
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @PathVariable int catId) {
        ProductDto addedProduct = this.productService.createProduct(product, catId);
        return new ResponseEntity<ProductDto>(addedProduct, HttpStatus.CREATED);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto product, @PathVariable int id) {
        ProductDto addedProduct = this.productService.updateProduct(id, product);
        return new ResponseEntity<ProductDto>(addedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok("Product successfully deleted!!");
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id){
        ProductDto product = this.productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> products = this.productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
