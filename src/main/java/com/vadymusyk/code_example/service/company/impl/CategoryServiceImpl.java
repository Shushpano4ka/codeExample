package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategory(long categoryId) {
        return Optional.ofNullable(categoryRepository.findOne(categoryId))
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + categoryId + " not found"));
    }

    @Override
    public Category addNewCategory(String name) {
        return categoryRepository.save(Category
                .builder()
                .name(name.toLowerCase())
                .build());
    }

    @Override
    public Category updateCategory(long categoryId, String name) {
        Category category = categoryRepository.findOne(categoryId);
        category.setName(name);
        return categoryRepository.save(category);
    }
}
