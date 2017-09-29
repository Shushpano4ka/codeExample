package com.vadymusyk.code_example.entity.company.rating;


import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.secutity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department_rating")
public class DepartmentRating {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private Department department;

    @ManyToOne
    private User user;

    @Min(1)
    @Max(5)
    private int rating;
}
