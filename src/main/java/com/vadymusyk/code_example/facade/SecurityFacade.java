package com.vadymusyk.code_example.facade;

import com.vadymusyk.code_example.dto.company.CategoryDTO;
import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.secutity.User;

import java.util.List;

/**
 * Created by vadymusyk on 14.08.17.
 */
public interface SecurityFacade {

    boolean isUnauthorized();

    User getUser();

    DepartmentDTO createDTOIncludeAuthorization(Department department, List<CategoryDTO> categoryDTOS);

}
