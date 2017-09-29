package com.vadymusyk.code_example.entity.company;

import com.vadymusyk.code_example.entity.secutity.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull(message = "company must have owner")
    private User owner;

    @JoinColumn(name = "company_birthday")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime companyBirthday;
}
