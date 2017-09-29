package com.vadymusyk.code_example.converter.company;

import com.vadymusyk.code_example.dto.company.CategoryDTO;
import com.vadymusyk.code_example.dto.company.TagDTO;
import com.vadymusyk.code_example.entity.company.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class CategoryConverter {
    public static List<CategoryDTO> toDTOList(List<Category> categories) {
        return categories.stream()
                .map(CategoryConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .build();
    }

    public static List<CategoryDTO> getCategoryDTOList(Department department) {
        Map<Category, List<Tag>> categoryTagsMap = new HashMap<>();
        List<SimilarDepartment> similarDepartments = department.getSimilarDepartments();

        similarDepartments
                .forEach(similarDepartment -> {
                            Category key = similarDepartment.getCategoryTag().getCategory();
                            Tag tag = similarDepartment.getCategoryTag().getTag();
                            List<Tag> result = new ArrayList<>();
                            if (categoryTagsMap.containsKey(key)) {
                                List<Tag> tags = categoryTagsMap.get(key);
                                if (!tags.isEmpty()) {
                                    result.addAll(tags);
                                }
                                result.add(tag);
                                categoryTagsMap.put(key, result);
                            } else {
                                categoryTagsMap.put(key, Arrays.asList(tag));
                            }
                        }
                );

        //include categories without tags
        List<DepartmentCategory> categories = department.getCategories();
        categories.forEach(departmentCategory -> {
            if (!categoryTagsMap.containsKey(departmentCategory.getCategory())) {
                categoryTagsMap.put(departmentCategory.getCategory(), new ArrayList<>());
            }
        });

        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categoryTagsMap.forEach((k, v) -> {
            CategoryDTO categoryDTO = CategoryConverter.toDTO(k);
            List<TagDTO> tagDTOs = TagConverter.toDTOList(v);
            categoryDTO.setCategoryTags(tagDTOs);
            categoryDTOS.add(categoryDTO);
        });
        return categoryDTOS;
    }


}
