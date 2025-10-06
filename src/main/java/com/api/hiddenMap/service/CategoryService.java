package com.api.hiddenMap.service;

import com.api.hiddenMap.entity.CategoryEntity;
import com.api.hiddenMap.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategory(){
        return  categoryRepository.findAll();
    }

    public CategoryEntity getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public CategoryEntity createCategory(CategoryEntity entity){
        return categoryRepository.save(entity);
    }

    public CategoryEntity updateCategory(CategoryEntity entity,Long id){
        CategoryEntity update = categoryRepository.findById(id).orElse(null);
        update.setName(entity.getName());
        update.setDescription(entity.getDescription());
        return categoryRepository.save(update);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
