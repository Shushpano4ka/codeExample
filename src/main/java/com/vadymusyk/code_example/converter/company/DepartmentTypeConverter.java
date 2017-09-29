package com.vadymusyk.code_example.converter.company;

import com.vadymusyk.code_example.dto.company.DepartmentTypeDTO;
import com.vadymusyk.code_example.entity.company.DepartmentType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class DepartmentTypeConverter {
    public static List<DepartmentTypeDTO> toDTOList(List<DepartmentType> departmentTypes) {
        return departmentTypes.stream()
                .map(DepartmentTypeConverter::toDTO)
                .collect(Collectors.toList());
    }

    public static DepartmentTypeDTO toDTO(DepartmentType departmentType) {
        return DepartmentTypeDTO.builder()
                .departmentTypeId(departmentType.getId())
                .type(departmentType.getType())
                .build();
    }
}
