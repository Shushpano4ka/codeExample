package com.vadymusyk.code_example.service.company.rating;

import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import com.vadymusyk.code_example.entity.secutity.User;

import java.util.List;

public interface DepartmentRatingService {
    DepartmentRating getRating(long departmentId, long userId);

    DepartmentRating voteForDepartment(DepartmentRating departmentRating);

    List<DepartmentRating> getAllRatingsInDepartment(long departmentId);

    boolean hasUserVoted(User user, Department department);
}
