package com.vadymusyk.code_example.entity.secutity;

import com.vadymusyk.code_example.entity.company.Department;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_favorite_departments")
public class UserFavoriteDepartment {
    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Department department;
}
