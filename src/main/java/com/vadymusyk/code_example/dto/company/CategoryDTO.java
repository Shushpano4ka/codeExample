package com.vadymusyk.code_example.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private long categoryId;
    private String name;
    private List<TagDTO> categoryTags = new ArrayList<>();
}
