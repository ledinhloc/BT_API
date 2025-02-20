package com.android.APILogin.controller;

import com.android.APILogin.entity.Category;
import com.android.APILogin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getCategory() {
        return  categoryService.getAllCategories();
    }
}
