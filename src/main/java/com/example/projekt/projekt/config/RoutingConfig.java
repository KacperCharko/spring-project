package com.example.projekt.projekt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RoutingConfig implements WebMvcConfigurer {

    public void addViewControllers (ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home/index");
        registry.addViewController("").setViewName("home/index");
        registry.addViewController("/home").setViewName("home/index");
        registry.addViewController("/hello").setViewName("home/hello");
        registry.addViewController("/login").setViewName("home/login");
        registry.addViewController("/h").setViewName("home/index");
    }
}