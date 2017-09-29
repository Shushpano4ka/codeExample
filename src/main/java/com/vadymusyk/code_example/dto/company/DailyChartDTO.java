package com.vadymusyk.code_example.dto.company;

import com.vadymusyk.code_example.entity.company.schedule.Day;
import lombok.*;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyChartDTO {
    private Day day;
    private boolean isOpen;
    private boolean hasBreak;
    private Integer openingHour, closingHour, breakStatingHour, breakEndingHour;
}
