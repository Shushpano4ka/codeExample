package com.vadymusyk.code_example.dto.company;

import com.vadymusyk.code_example.entity.company.DepartmentStatus;
import com.vadymusyk.code_example.entity.secutity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntityAmountDTO {
    private DepartmentStatus departmentStatus;
    private Role userRole;
    private Integer amount;
}
