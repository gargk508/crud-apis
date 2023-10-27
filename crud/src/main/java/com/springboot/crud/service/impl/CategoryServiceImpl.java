package com.springboot.crud.service.impl;

import com.springboot.crud.entity.Category;
import com.springboot.crud.payload.CategoryDto;
import com.springboot.crud.repository.CategoryRepository;
import com.springboot.crud.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(int id){
        Category category = categoryRepository.findById(id).orElseThrow();
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto category) {
        Category cat = this.modelMapper.map(category, Category.class);
        Category addedCategory = categoryRepository.save(cat);
        return this.modelMapper.map(addedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(int id, CategoryDto category) {
        Category cat = categoryRepository.findById(id).orElseThrow();
        cat.setCategoryName(category.getCategoryName());
        Category updatedCategory = categoryRepository.save(cat);
        return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }
}
