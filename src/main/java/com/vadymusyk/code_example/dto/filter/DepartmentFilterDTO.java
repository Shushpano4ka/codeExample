package com.vadymusyk.code_example.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentFilterDTO {
    private Double lat;
    private Double lng;
    private Double radiusKm;
    private Long categoryId;
    private Long brandId;
    private String searchValue;
    private List<Long> tagIds = new ArrayList<>();
}
