package com.example.projekt.projekt.controllers;

import com.example.projekt.projekt.models.helpers.CategoryModel;
import com.example.projekt.projekt.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    private IndexController indexController;

    public CategoryController(CategoryService categoryService, IndexController indexController) {
        this.categoryService = categoryService;
        this.indexController = indexController;
    }

    @RequestMapping("/create")
    public String createCategory (@ModelAttribute(value = "Cat") CategoryModel categoryModel, Model model){
        categoryService.createCategory(categoryModel);
        return indexController.getAllCategories(model);
    }

    @RequestMapping("/delete")
    public String deleteCategory (@ModelAttribute(value = "Cat") CategoryModel categoryModel, Model model){
        categoryService.createCategory(categoryModel);

        return indexController.getAllCategories(model);
    }
}
