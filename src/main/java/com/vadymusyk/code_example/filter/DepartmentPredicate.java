package com.vadymusyk.code_example.filter;

import com.vadymusyk.code_example.dto.filter.DepartmentFilterDTO;
import com.vadymusyk.code_example.entity.company.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by vadymusyk on 16.08.17.
 */
public class DepartmentPredicate implements Predicate<Department> {

    private Long categoryId;
    private Long brandId;
    private String searchValue;
    private List<Long> tagIds = new ArrayList<>();

    private Predicate<Department> compositePredicate;

    public DepartmentPredicate(DepartmentFilterDTO departmentFilterDTO) {
        this.categoryId = departmentFilterDTO.getCategoryId();
        this.brandId = departmentFilterDTO.getBrandId();
        this.searchValue = departmentFilterDTO.getSearchValue();
        this.tagIds.addAll(departmentFilterDTO.getTagIds());
        createCompositePredicate();
    }

    private void createCompositePredicate() {
        this.compositePredicate = Stream.of(
                brandPredicate,
                categoryPredicate,
                searchValuePredicate,
                categoryTagsPredicate
        ).reduce(p -> true, Predicate::and);
    }

    @Override
    public boolean test(Department department) {
        return this.compositePredicate.test(department);
    }

    private Predicate<Department> brandPredicate = department -> brandId == null || department.getDepartmentBrands().stream()
            .anyMatch(departmentBrand -> departmentBrand.getBrand().getId() == brandId);

    private Predicate<Department> categoryPredicate = department -> categoryId == null || department.getCategories().stream()
            .anyMatch(departmentCategory -> departmentCategory.getCategory().getId() == categoryId);

    private Predicate<Department> searchValuePredicate = department -> searchValue == null || searchValue.length() < 4
            || department.getName().contains(searchValue) || department.getAddress().contains(searchValue) || department.getDepartmentBrands().stream()
            .anyMatch(departmentBrand -> departmentBrand.getBrand().getName().contains(searchValue));

    private Predicate<Department> categoryTagsPredicate = department -> tagIds.isEmpty() || department.getSimilarDepartments().stream()
            .anyMatch(similarDepartments ->
                    tagIds.stream()
                            .anyMatch(id ->
                                    id == similarDepartments.getCategoryTag().getTag().getId()
                            ));
}
