package com.vadymusyk.code_example.dto.company.schedule;

import com.vadymusyk.code_example.dto.company.DailyChartDTO;
import com.vadymusyk.code_example.validator.schedule.ScheduleConstraint;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class DepartmentScheduleDTO {

    @Min(1)
    private long departmentId;

    @ScheduleConstraint
    private List<DailyChartDTO> chartDTOList = new ArrayList<>();
}
