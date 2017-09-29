package com.vadymusyk.code_example.dto.company.comment;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewCommentDTO {

    @NotEmpty
    @NotNull
    private String message;

    private Long parentId;

    @Min(1)
    private long departmentId;

    private String imageUrl;
}
