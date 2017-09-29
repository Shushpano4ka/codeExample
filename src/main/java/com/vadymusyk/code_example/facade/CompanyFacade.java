package com.vadymusyk.code_example.facade;

import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.dto.company.NewDepartmentDTO;
import com.vadymusyk.code_example.dto.filter.DepartmentFilterDTO;
import com.vadymusyk.code_example.entity.company.DepartmentStatus;

import java.util.List;

/**
 * Created by vadymusyk on 15.08.17.
 */
public interface CompanyFacade {
    List<DepartmentDTO> getDepartmentsByFilter(DepartmentFilterDTO departmentFilterDTO);

    DepartmentDTO voteForDepartment(long departmentId, int rate);

}