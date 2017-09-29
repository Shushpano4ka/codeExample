package com.vadymusyk.code_example.entity.secutity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 08.02.17.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Token {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private User user;

    @NotEmpty
    @NotNull(message = "token can't be empty")
    private String token;
}
