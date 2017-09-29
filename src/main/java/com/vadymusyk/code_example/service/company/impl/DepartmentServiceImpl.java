package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.repository.company.DepartmentRepository;
import com.vadymusyk.code_example.service.company.DepartmentService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.util.GeometricShapeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private final double Y = 111.11;

    @Override
    public List<Department> getDepartmentInRadius(Double lat, Double lng, Double radiusKm) {
        Polygon filterEllipse = createFilterForSearchInRegion(lat, lng, radiusKm);
        return departmentRepository.findInRegion(filterEllipse);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getDepartments(long companyId) {
        return departmentRepository.findByCompanyId(companyId);
    }

    @Override
    public Department getDepartment(long departmentId) {
        departmentRepository.flush();
        return Optional.ofNullable(departmentRepository.findOne(departmentId))
                .orElseThrow(() -> new EntityNotFoundException("department with id " + departmentId + "not found"));
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    private Polygon createFilterForSearchInRegion(double lat, double lng, double radiusKm) {

        GeometricShapeFactory filterEllipse = new GeometricShapeFactory();
        filterEllipse.setNumPoints(1000);
        filterEllipse.setCentre(new Coordinate(lat, lng));

        float degree = 40000f / 360f;
        double cosResult = Math.cos(lat * Math.PI / 180);
        double x = degree * cosResult;
        double width = (radiusKm * 2) / Y;
        double height = (radiusKm * 2) / x;
        filterEllipse.setWidth(width);
        filterEllipse.setHeight(height);
        return filterEllipse.createEllipse();
    }
}
