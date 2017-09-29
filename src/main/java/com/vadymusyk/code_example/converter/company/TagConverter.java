package com.vadymusyk.code_example.converter.company;

import com.vadymusyk.code_example.dto.company.TagDTO;
import com.vadymusyk.code_example.entity.company.CategoryTag;
import com.vadymusyk.code_example.entity.company.Tag;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 16.08.17.
 */
public class TagConverter {


    public static List<TagDTO> toDTOListFromCategoryTagList(List<CategoryTag> tagsInCategory) {
        return tagsInCategory.stream()
                .map(CategoryTag::getTag)
                .map(TagConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static List<TagDTO> toDTOList(List<Tag> tags) {
        return tags.stream()
                .map(TagConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static TagDTO toDTO(Tag tag) {
        return new TagDTO(tag.getId(), tag.getTag());
    }
}
