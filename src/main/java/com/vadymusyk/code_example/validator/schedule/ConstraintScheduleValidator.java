package com.vadymusyk.code_example.validator.schedule;

import com.vadymusyk.code_example.dto.company.DailyChartDTO;
import com.vadymusyk.code_example.entity.company.schedule.Day;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintScheduleValidator implements ConstraintValidator<ScheduleConstraint, List<DailyChartDTO>> {

    @Override
    public void initialize(ScheduleConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(List<DailyChartDTO> dailyChartDTOS, ConstraintValidatorContext context) {
        return !dailyChartDTOS.isEmpty() && includeAllWeekDailyCharts(dailyChartDTOS) && dailyChartDTOS.stream()
                .allMatch(this::checkCorrectProperties);
    }

    private boolean includeAllWeekDailyCharts(List<DailyChartDTO> dailyChartDTOS) {
        Set<Day> days = new HashSet<>();
        dailyChartDTOS.forEach(dailyChartDTO -> days.add(dailyChartDTO.getDay()));
        return dailyChartDTOS.size() == 7;
    }

    private boolean checkCorrectProperties(DailyChartDTO dailyChartDTO) {
        boolean isOk = true;
        if (dailyChartDTO.getDay() == null) {
            return false;
        } else if (dailyChartDTO.isOpen()) {
            if (dailyChartDTO.getOpeningHour() == null || dailyChartDTO.getClosingHour() == null) {
                isOk = false;
            } else {
                if (dailyChartDTO.getBreakStatingHour() == null || dailyChartDTO.getBreakEndingHour() == null) {
                    isOk = false;
                }
            }
        }
        return isOk;
    }
}
