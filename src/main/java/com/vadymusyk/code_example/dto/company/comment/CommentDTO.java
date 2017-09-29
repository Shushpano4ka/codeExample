package com.vadymusyk.code_example.dto.company.comment;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private String message;

    private long creatorId;

    private String imageUrl;

    private long createDateUNIX;
}
