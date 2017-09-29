package com.vadymusyk.code_example.entity.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "department_brands")
public class DepartmentBrand {


    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    @NotNull
    private Brand brand;

    @ManyToOne
    @NotNull
    private Department department;
}
