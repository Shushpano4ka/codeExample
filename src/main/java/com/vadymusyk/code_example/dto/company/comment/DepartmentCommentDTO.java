package com.vadymusyk.code_example.dto.company.comment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentCommentDTO {

    private long creatorId;

    private String message;

    private String imageUrl;

    private long createDateUNIX;

    private CommentDTO reply;
}
