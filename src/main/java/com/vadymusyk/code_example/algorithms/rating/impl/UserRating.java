package com.vadymusyk.code_example.algorithms.rating.impl;

import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRating extends DepartmentRating {
    private int rating;
}
