package com.vadymusyk.code_example.repository.company.rating;

import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRatingRepository extends JpaRepository<DepartmentRating, Long>{

    Optional<DepartmentRating> findByDepartmentIdAndUserId(long departmentId, long userId);
    List<DepartmentRating> findByDepartmentId(long departmentId);
}
