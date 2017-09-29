package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.CategoryTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Service
public class CategoryTagServiceImpl implements CategoryTagService {

    @Autowired
    private CategoryTagRepository categoryTagRepository;

    @Override
    public List<CategoryTag> getTagsInCategory(long categoryId) {
        return categoryTagRepository.findByCategoryId(categoryId);
    }

    @Override
    public CategoryTag findByCategoryIdAndTagId(long categoryId, long tagId) {
        return Optional.ofNullable(categoryTagRepository.findByCategoryIdAndTagId(categoryId, tagId))
                .orElseThrow(() -> new EntityNotFoundException("no dependency between tag with id " + tagId +
                        " and category with id " + categoryId));
    }

    @Override
    public void deleteCategoryTag(CategoryTag categoryTag) {
        categoryTagRepository.delete(categoryTag);
    }

    @Override
    public CategoryTag addCategoryTag(CategoryTag categoryTag) {
        return categoryTagRepository.save(categoryTag);
    }
}
