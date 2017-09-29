package com.vadymusyk.code_example.converter.company;

import com.vadymusyk.code_example.converter.company.properties.PhoneNumberConverter;
import com.vadymusyk.code_example.converter.company.properties.ScheduleConverter;
import com.vadymusyk.code_example.converter.measurements.LocationConverter;
import com.vadymusyk.code_example.dto.company.CategoryDTO;
import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.dto.company.NewDepartmentDTO;
import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.DepartmentBrand;
import com.vadymusyk.code_example.entity.secutity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 16.08.17.
 */
public class DepartmentConverter {


    public static List<DepartmentDTO> toDTOList(List<Department> departments) {
        return departments.stream().
                map(DepartmentConverter::toDTO)
                .collect(Collectors.toList());
    }

    private static DepartmentDTO toDTOInList(Department department) {
        return DepartmentDTO.builder()
                .departmentId(department.getId())
                .rating(department.getRating())
                .address(department.getAddress())
                .departmentTypeId(department.getType().getId())
                .name(department.getName())
                .rating(department.getRating())
                .build();
    }

    public static List<DepartmentDTO> toDTOListIncludeOwnerAndFavorite(List<Department> departments, User user) {
        return departments.stream()
                .map(department -> {
                    DepartmentDTO departmentDTO = toDTOInList(department);
                    department.getFavoriteDepartments()
                            .forEach(userFavoriteDepartment -> {
                                if (userFavoriteDepartment.getUser().getId() == user.getId()) {
                                    departmentDTO.setIsFavorite(true);
                                }
                            });
                    if (departmentDTO.getOwnerId() == user.getId()) {
                        departmentDTO.setIsOwner(true);
                    }
                    return departmentDTO;
                })
                .collect(Collectors.toList());
    }

    public static Department toModel(NewDepartmentDTO newDepartmentDTO) {
        return Department.builder()
                .address(newDepartmentDTO.getAddress())
                .name(newDepartmentDTO.getName())
                .siteUrl(Optional.ofNullable(newDepartmentDTO.getSiteUrl()).orElse(""))
                .location(LocationConverter.toPoint(newDepartmentDTO.getLatitude(), newDepartmentDTO.getLongitude()))
                .build();
    }

    public static DepartmentDTO toDTO(Department department) {
        return DepartmentDTO.builder()
                .departmentId(department.getId())
                .ownerId(department.getCompany().getOwner().getId())
                .latitude(department.getLocation().getX())
                .longitude(department.getLocation().getY())
                .name(department.getName())
                .address(department.getAddress())
                .departmentTypeId(department.getType().getId())
                .rating(department.getRating())
                .build();
    }

    public static DepartmentDTO toFullDTO(Department department, List<CategoryDTO> categoryDTOS, User user, boolean hasVoted) {
        DepartmentDTO build = toFullDTOForUnauthorized(department, categoryDTOS);
        build.setHasUserVoted(hasVoted);
        department.getFavoriteDepartments().forEach(userFavoriteDepartment -> {
            if (userFavoriteDepartment.getUser().getId() == user.getId()) {
                build.setIsFavorite(true);
            }
        });
        if (department.getCompany().getOwner().getId() == user.getId()) {
            build.setIsOwner(true);
        }
        return build;
    }

    public static DepartmentDTO toFullDTOForUnauthorized(Department department, List<CategoryDTO> categoryDTOS) {
        return DepartmentDTO.builder()
                .departmentId(department.getId())
                .ownerId(department.getCompany().getOwner().getId())
                .name(department.getName())
                .siteUrl(department.getSiteUrl())
                .departmentTypeId(department.getType().getId())
                .longitude(department.getLocation().getY())
                .latitude(department.getLocation().getX())
                .address(department.getAddress())
                .rating(department.getRating())
                .brands(BrandConverter.toDTOList(department.getDepartmentBrands().stream()
                        .map(DepartmentBrand::getBrand)
                        .collect(Collectors.toList())))
                .phoneNumbers(PhoneNumberConverter.toDTOList(department.getPhoneNumbers()))
                .schedule(ScheduleConverter.toDTOList(department.getSchedule()))
                .categories(categoryDTOS)
                .isFavorite(false)
                .isOwner(false)
                .build();
    }


}
