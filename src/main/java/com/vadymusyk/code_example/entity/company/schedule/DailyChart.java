package com.vadymusyk.code_example.entity.company.schedule;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "daily_chart")
public class DailyChart {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private Department department;

    @Enumerated(value = EnumType.STRING)
    private Day day;

    private boolean isOpen;
    private boolean hasBreak;

    @Column(name = "opening_hour")
    private Integer openingHour;

    @Column(name = "closing_hour")
    private Integer closingHour;

    @Column(name = "break_start")
    private Integer breakStatingHour;

    @Column(name = "break_stop")
    private Integer breakEndingHour;

}
