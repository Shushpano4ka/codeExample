package com.vadymusyk.code_example.converter.company.properties;

import com.vadymusyk.code_example.dto.company.DailyChartDTO;
import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.company.schedule.DailyChart;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleConverter {
    public static DailyChart toModel(DailyChartDTO dailyChartDTO, Department department) {
        return DailyChart.builder()
                .day(dailyChartDTO.getDay())
                .hasBreak(dailyChartDTO.isHasBreak())
                .isOpen(dailyChartDTO.isOpen())
                .openingHour(dailyChartDTO.getOpeningHour())
                .closingHour(dailyChartDTO.getClosingHour())
                .breakStatingHour(dailyChartDTO.getBreakStatingHour())
                .breakEndingHour(dailyChartDTO.getBreakEndingHour())
                .department(department)
                .build();
    }

    public static List<DailyChartDTO> toDTOList(List<DailyChart> schedule) {
        return schedule.stream()
                .map(ScheduleConverter::toDTO)
                .collect(Collectors.toList());
    }

    private static DailyChartDTO toDTO(DailyChart dailyChart) {
        return DailyChartDTO.builder()
                .day(dailyChart.getDay())
                .isOpen(dailyChart.isOpen())
                .hasBreak(dailyChart.isHasBreak())
                .openingHour(dailyChart.getOpeningHour())
                .closingHour(dailyChart.getClosingHour())
                .breakStatingHour(dailyChart.getBreakStatingHour())
                .breakEndingHour(dailyChart.getBreakEndingHour())
                .build();
    }
}
