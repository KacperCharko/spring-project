package com.example.projekt.projekt.models.helpers;



public class CategoryModel {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;

    public CategoryModel() {

    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
