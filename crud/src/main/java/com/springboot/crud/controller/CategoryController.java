package com.springboot.crud.controller;

import com.springboot.crud.payload.CategoryDto;
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
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category) {
        CategoryDto addedCategory = this.categoryService.createCategory(category);
        return new ResponseEntity<CategoryDto>(addedCategory, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category, @PathVariable int id) {
        CategoryDto addedCategory = this.categoryService.updateCategory(id, category);
        return new ResponseEntity<CategoryDto>(addedCategory, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category successfully deleted!!");
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
        CategoryDto category = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }
}
