package com.vadymusyk.code_example.facade.impl;

import com.vadymusyk.code_example.algorithms.rating.WilsonScoreIntervalAlgorithm;
import com.vadymusyk.code_example.converter.company.CategoryConverter;
import com.vadymusyk.code_example.converter.company.DepartmentConverter;
import com.vadymusyk.code_example.dto.company.CategoryDTO;
import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.dto.filter.DepartmentFilterDTO;
import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.DepartmentStatus;
import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import com.vadymusyk.code_example.entity.secutity.Role;
import com.vadymusyk.code_example.entity.secutity.User;
import com.vadymusyk.code_example.exception.functional.rating.UsersVoteForDepartmentException;
import com.vadymusyk.code_example.exception.security.AccessToDepartmentDenied;
import com.vadymusyk.code_example.facade.CompanyFacade;
import com.vadymusyk.code_example.facade.SecurityFacade;
import com.vadymusyk.code_example.filter.DepartmentPredicate;
import com.vadymusyk.code_example.service.company.DepartmentService;
import com.vadymusyk.code_example.service.company.rating.DepartmentRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Component
public class CompanyFacadeImpl implements CompanyFacade {

    private DepartmentService departmentService;
    private SecurityFacade securityFacade;
    private DepartmentRatingService departmentRatingService;
    private WilsonScoreIntervalAlgorithm wilsonScoreIntervalAlgorithm;

    @Autowired
    public CompanyFacadeImpl(DepartmentService departmentService, SecurityFacade securityFacade, DepartmentRatingService departmentRatingService, WilsonScoreIntervalAlgorithm wilsonScoreIntervalAlgorithm) {
        this.departmentService = departmentService;
        this.securityFacade = securityFacade;
        this.departmentRatingService = departmentRatingService;
        this.wilsonScoreIntervalAlgorithm = wilsonScoreIntervalAlgorithm;
    }

    @Override
    public List<DepartmentDTO> getDepartmentsByFilter(DepartmentFilterDTO departmentFilterDTO) {
        List<Department> departments;
        if (filterIncludeGeoPosition(departmentFilterDTO)) {
            departments = departmentService.getDepartmentInRadius(departmentFilterDTO.getLat(),
                    departmentFilterDTO.getLng(), departmentFilterDTO.getRadiusKm());
        } else departments = departmentService.getAllDepartments();

        DepartmentPredicate predicate = new DepartmentPredicate(departmentFilterDTO);

        List<Department> afterFiltering = departments.stream()
                .filter(predicate)
                .filter(department -> department.getStatus().equals(DepartmentStatus.CONFIRMED))
                .collect(Collectors.toList());
        return discussionDTOListIncludeAuthorization(afterFiltering);
    }

    @Override
    public DepartmentDTO voteForDepartment(long departmentId, int rate) {
        User user = securityFacade.getUser();
        Department updatedDepartment = null;
        if (!user.getRole().equals(Role.USER)) {
            throw new AccessToDepartmentDenied("only USER has a possibility to vote for department");
        } else {

            try {
                DepartmentRating departmentRating = departmentRatingService.getRating(departmentId, user.getId());
                throw new UsersVoteForDepartmentException("user with id " + user.getId() + " already vote for this department in " + departmentRating.getRating() + " stars");
            } catch (EntityNotFoundException e) {
                Department department = departmentService.getDepartment(departmentId);
                if (department.getCompany().getOwner().getId() == user.getId()) {
                    throw new UsersVoteForDepartmentException("Owner can't vote for his department");
                }
                departmentRatingService.voteForDepartment(DepartmentRating.builder()
                        .department(department)
                        .user(user)
                        .rating(rate)
                        .build());
                List<DepartmentRating> departmentRatings = departmentRatingService.getAllRatingsInDepartment(departmentId);
                Double rating = wilsonScoreIntervalAlgorithm.countRating(departmentRatings);
                department.setRating(rating);
                updatedDepartment = departmentService.updateDepartment(department);
            }
        }
        return DepartmentDTO.builder().rating(updatedDepartment.getRating()).build();

    }

    private List<DepartmentDTO> discussionDTOListIncludeAuthorization(List<Department> afterFiltering) {
        if (securityFacade.isUnauthorized()) {
            return DepartmentConverter.toDTOList(afterFiltering);
        } else {
            User user = securityFacade.getUser();
            return DepartmentConverter.toDTOListIncludeOwnerAndFavorite(afterFiltering, user);
        }
    }

    private boolean filterIncludeGeoPosition(DepartmentFilterDTO departmentFilterDTO) {
        return departmentFilterDTO.getRadiusKm() != null && departmentFilterDTO.getLat() != null
                && departmentFilterDTO.getLng() != null && departmentFilterDTO.getRadiusKm() > 0;
    }


    private DepartmentDTO collectFullDiscussionDTO(Department department) {
        List<CategoryDTO> categoryDTOList = CategoryConverter.getCategoryDTOList(department);
        return securityFacade.createDTOIncludeAuthorization(department, categoryDTOList);

    }

}
