package com.api.hiddenMap.controller;

import com.api.hiddenMap.entity.CategoryEntity;
import com.api.hiddenMap.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryEntity> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public  CategoryEntity getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping()
    public  CategoryEntity createCategory(@RequestBody CategoryEntity category){
        return  categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public CategoryEntity updateCategory(@PathVariable Long id,@RequestBody CategoryEntity category){
        return  categoryService.updateCategory(category,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
         categoryService.deleteCategory(id);
    }
}
