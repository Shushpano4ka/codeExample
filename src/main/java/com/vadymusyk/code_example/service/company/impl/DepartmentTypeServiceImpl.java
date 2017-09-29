package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.DepartmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Service
public class DepartmentTypeServiceImpl implements DepartmentTypeService {

    @Autowired
    private DepartmentTypeRepository departmentTypeRepository;

    @Override
    public List<DepartmentType> getAllDepartmentTypes() {
        return departmentTypeRepository.findAll();
    }

    @Override
    public DepartmentType getDepartmentType(long departmentTypeId) {
        return Optional.ofNullable(departmentTypeRepository.findOne(departmentTypeId))
                .orElseThrow(() -> new EntityNotFoundException("DepartmentType with Id " + departmentTypeId +
                        " not found"));
    }

    @Override
    public DepartmentType addNewDepartmentType(String type) {
        return departmentTypeRepository.save(DepartmentType.builder().type(type.toLowerCase()).build());
    }

    @Override
    public DepartmentType updateDepartmentType(long departmentTypeId, String type) {
        DepartmentType departmentType = getDepartmentType(departmentTypeId);
        departmentType.setType(type);
        return departmentTypeRepository.save(departmentType);
    }
}
