package com.springboot.crud.service.impl;

import com.springboot.crud.entity.Category;
import com.springboot.crud.repository.CategoryRepository;
import com.springboot.crud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(int id){
        Category category = categoryRepository.findById(id).orElseThrow();
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }

    @Override
    public Category createCategory(Category category) {
        Category addedCategory = categoryRepository.save(category);
        return addedCategory;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category cat = categoryRepository.findById(id).orElseThrow();
        cat.setCategoryName(category.getCategoryName());
//        cat.setProducts(category.getProducts());
        Category updatedCategory = categoryRepository.save(cat);
        return updatedCategory;
    }
}
