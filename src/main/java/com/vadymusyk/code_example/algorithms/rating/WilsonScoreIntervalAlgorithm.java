package com.vadymusyk.code_example.algorithms.rating;

import com.vadymusyk.code_example.algorithms.rating.impl.UserRating;
import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;

import java.util.List;

public interface WilsonScoreIntervalAlgorithm {
    Double countRating(List<DepartmentRating> ratingList);

    Double countRating(List<UserRating> userRatings2, boolean isTest);
}
