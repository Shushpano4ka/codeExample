package com.vadymusyk.code_example.entity.secutity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by vadymusyk on 14.08.17.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "password_recoveries")
public class PasswordRecovery {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private User user;

    @Column(name = "new_password")
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JoinColumn(name = "update_time")
    private LocalDateTime updateTime;

    private String token;
}
