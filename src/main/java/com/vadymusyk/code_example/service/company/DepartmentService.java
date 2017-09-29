package com.vadymusyk.code_example.service.company;

import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.DepartmentStatus;

import java.util.List;

/**
 * Created by vadymusyk on 16.08.17.
 */
public interface DepartmentService {
    List<Department> getDepartmentInRadius(Double lat, Double lng, Double radiusKm);

    List<Department> getAllDepartments();

    List<Department> getDepartments(long companyId);

    Department getDepartment(long departmentId);

    Department updateDepartment(Department department);
}
