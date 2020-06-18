package com.example.projekt.projekt.controllers;

import com.example.projekt.projekt.models.Category;
import com.example.projekt.projekt.models.Thread;
import com.example.projekt.projekt.models.helpers.CategoryThreads;
import com.example.projekt.projekt.models.helpers.CategoryModel;
import com.example.projekt.projekt.models.helpers.ThreadViewModel;
import com.example.projekt.projekt.service.CategoryService;
import com.example.projekt.projekt.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/home")
public class IndexController {

    CategoryService categoryService;
    ThreadService threadService;

    @Autowired
    public IndexController(CategoryService categoryService, ThreadService threadService){
        this.threadService = threadService;
        this.categoryService = categoryService;
    }

    @GetMapping("/index")
    public String getAllCategories(Model model){

        Iterable<Category> categories = categoryService.getAll();
        Iterable<Thread> threads = threadService.getAllThreads();
        ArrayList<CategoryThreads> categoryThreads = new ArrayList<CategoryThreads>();
        StreamSupport.stream(categories.spliterator(),false)
                .forEach(category -> {
                    Iterable<Thread> threadsHelper = StreamSupport.stream(threads.spliterator(),false)
                            .filter(thread -> thread.getCategoryId().equals(category.getCategoryId()))
                            .collect(Collectors.toList());
                    categoryThreads.add(new CategoryThreads(category,threadsHelper));
                });

        model.addAttribute("categories",categoryThreads);
        model.addAttribute("choosenThread", new ThreadViewModel());
        model.addAttribute("Cat", new CategoryModel());

        return "home/index";
    }



    @GetMapping("/")
    public String index(Principal principal, Model model) {
        return  this.getAllCategories(model);
    }
}
