package com.vadymusyk.code_example.dto.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewDepartmentDTO {

    private long departmentTypeId;

    @NotNull
    private String address, name;

    private String siteUrl;

    private double latitude, longitude;

}
