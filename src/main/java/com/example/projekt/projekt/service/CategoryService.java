package com.example.projekt.projekt.service;

import com.example.projekt.projekt.models.Category;
import com.example.projekt.projekt.models.helpers.CategoryModel;
import com.example.projekt.projekt.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public Category createCategory (CategoryModel categoryModel){
        Category category = new Category();
        category.setCategoryName(categoryModel.getCategoryName());
        category.setCategoryDescription(categoryModel.getCategoryDescription());

        categoryRepo.save(category);
        return category;
    }

    public Iterable<Category> getAll(){
        return categoryRepo.findAll();
    }

}
