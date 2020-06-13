package com.example.projekt.projekt.service;

import com.example.projekt.projekt.models.Category;
import com.example.projekt.projekt.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public ResponseEntity<Category> createCategory (Category category){
        categoryRepo.save(category);
        return ResponseEntity.ok(category);
    }

    public Iterable<Category> getAll(){
        return categoryRepo.findAll();
    }

}
