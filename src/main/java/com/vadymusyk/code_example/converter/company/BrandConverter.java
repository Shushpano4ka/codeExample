package com.vadymusyk.code_example.converter.company;

import com.vadymusyk.code_example.dto.company.BrandDTO;
import com.vadymusyk.code_example.entity.company.Brand;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class BrandConverter {


    public static List<BrandDTO> toDTOList(List<Brand> brands) {
        return brands.stream()
                .map(BrandConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static BrandDTO toDTO(Brand brand) {
        return BrandDTO.builder()
                .brandId(brand.getId())
                .name(brand.getName())
                .build();
    }
}
