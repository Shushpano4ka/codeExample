package com.vadymusyk.code_example.facade.impl;

import com.vadymusyk.code_example.converter.company.DepartmentConverter;
import com.vadymusyk.code_example.dto.company.CategoryDTO;
import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.secutity.User;
import com.vadymusyk.code_example.facade.SecurityFacade;
import com.vadymusyk.code_example.service.company.rating.DepartmentRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vadymusyk on 14.08.17.
 */
@Component
public class SecurityFacadeImpl implements SecurityFacade {

    private DepartmentRatingService departmentRatingService;

    @Autowired
    public SecurityFacadeImpl(DepartmentRatingService departmentRatingService) {
        this.departmentRatingService = departmentRatingService;
    }

    @Override
    public boolean isUnauthorized() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");
    }

    @Override
    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    @Override
    public DepartmentDTO createDTOIncludeAuthorization(Department department, List<CategoryDTO> categoryDTOS) {
        if (isUnauthorized()) {

            return DepartmentConverter.toFullDTOForUnauthorized(department, categoryDTOS);
        } else {
            User user = getUser();
            boolean hasVoted = departmentRatingService.hasUserVoted(user, department);
            return DepartmentConverter.toFullDTO(department, categoryDTOS, getUser(), hasVoted);
        }
    }
}
