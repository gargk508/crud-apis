package com.springboot.crud.service;

import com.springboot.crud.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(int id);
    void deleteCategory(int id);
    Category createCategory(Category category);
    Category updateCategory(int id, Category category);
}
