package com.springboot.crud.service;

import com.springboot.crud.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    CategoryDto getCategoryById(int id);
    void deleteCategory(int id);
    CategoryDto createCategory(CategoryDto category);
    CategoryDto updateCategory(int id, CategoryDto category);
}
