package com.vadymusyk.code_example.entity.company.contacts;

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
@Table(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private Department department;

    @Enumerated(value = EnumType.STRING)
    private NumberPriority priority;

    private String number;
}
