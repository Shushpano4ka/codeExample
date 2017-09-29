package com.vadymusyk.code_example.entity.company;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "department_type")
public class DepartmentType {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @NotEmpty
    @NotNull
    private String type;
}
