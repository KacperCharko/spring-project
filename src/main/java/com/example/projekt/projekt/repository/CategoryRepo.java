package com.example.projekt.projekt.repository;

import com.example.projekt.projekt.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository <Category, Long> {
}
