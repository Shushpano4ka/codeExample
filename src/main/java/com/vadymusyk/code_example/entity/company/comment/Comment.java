package com.vadymusyk.code_example.entity.company.comment;

import com.vadymusyk.code_example.entity.company.Department;
import com.vadymusyk.code_example.entity.secutity.User;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
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
public class Comment {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private Department department;

    @JoinColumn(name = "creator_id")
    @ManyToOne
    private User creator;

    @Column(name = "parent_id")
    private Long parentId;

    @NotNull
    @NotEmpty
    private String message;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(value = EnumType.STRING)
    private CommentStatus status;
}
