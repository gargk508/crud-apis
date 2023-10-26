package com.springboot.crud.controller;

import com.springboot.crud.entity.Category;
import com.springboot.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category addedCategory = this.categoryService.createCategory(category);
        return new ResponseEntity<Category>(addedCategory, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable int id) {
        Category addedCategory = this.categoryService.updateCategory(id, category);
        return new ResponseEntity<Category>(addedCategory, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category successfully deleted!!");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id){
        Category category = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
