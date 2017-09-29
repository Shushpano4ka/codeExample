package com.vadymusyk.code_example.service.company.rating.impl;

import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import com.vadymusyk.code_example.entity.secutity.User;
import com.vadymusyk.code_example.repository.company.rating.DepartmentRatingRepository;
import com.vadymusyk.code_example.service.company.rating.DepartmentRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartmentRatingServiceImpl implements DepartmentRatingService {

    @Autowired
    private DepartmentRatingRepository departmentRatingRepository;

    @Override
    public DepartmentRating getRating(long departmentId, long userId) {
        return departmentRatingRepository.findByDepartmentIdAndUserId(departmentId, userId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public DepartmentRating voteForDepartment(DepartmentRating departmentRating) {
        return departmentRatingRepository.save(departmentRating);
    }

    @Override
    public List<DepartmentRating> getAllRatingsInDepartment(long departmentId) {
        return departmentRatingRepository.findByDepartmentId(departmentId);
    }

    @Override
    public boolean hasUserVoted(User user, Department department) {

        return departmentRatingRepository.findByDepartmentIdAndUserId(department.getId(), user.getId()).isPresent();
    }
}
