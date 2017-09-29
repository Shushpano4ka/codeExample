package com.vadymusyk.code_example.dto.company.comment;

import com.vadymusyk.code_example.entity.company.comment.CommentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FullCommentDTO {

    private long commentId;
    private long departmentId;
    private String departmentName;
    private String departmentImageUrl;
    private long creatorId;
    private String message;
    private long createDate;
    private CommentStatus status;
    private boolean isReply;
    private String imageUrl;
}
