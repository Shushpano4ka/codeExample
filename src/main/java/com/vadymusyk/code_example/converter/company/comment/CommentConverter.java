package com.vadymusyk.code_example.converter.company.comment;

import com.vadymusyk.code_example.converter.measurements.DateConverter;
import com.vadymusyk.code_example.dto.company.comment.CommentDTO;
import com.vadymusyk.code_example.dto.company.comment.DepartmentCommentDTO;
import com.vadymusyk.code_example.dto.company.comment.FullCommentDTO;
import com.vadymusyk.code_example.entity.company.comment.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {
    public static DepartmentCommentDTO toDepartmentComment(Comment comment) {
        return DepartmentCommentDTO.builder()
                .createDateUNIX(DateConverter.convertToUnix(comment.getCreateDate()))
                .creatorId(comment.getCreator().getId())
                .message(comment.getMessage())
                .imageUrl(comment.getImageUrl())
                .build();
    }

    public static CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder()
                .createDateUNIX(DateConverter.convertToUnix(comment.getCreateDate()))
                .creatorId(comment.getCreator().getId())
                .message(comment.getMessage())
                .imageUrl(comment.getImageUrl())
                .build();
    }

    public static List<FullCommentDTO> toFullCommentDTOList(List<Comment> comments) {
        return comments.stream().map(CommentConverter::toFullCommentDTO)
                .collect(Collectors.toList());
    }

    public static FullCommentDTO toFullCommentDTO(Comment comment) {
        return FullCommentDTO.builder()
                .commentId(comment.getId())
                .createDate(DateConverter.convertToUnix(comment.getCreateDate()))
                .creatorId(comment.getCreator().getId())
                .departmentId(comment.getDepartment().getId())
                .departmentName(comment.getDepartment().getName())
                .departmentImageUrl(comment.getDepartment().getImageUrl())
                .imageUrl(comment.getImageUrl())
                .message(comment.getMessage())
                .status(comment.getStatus())
                .isReply(comment.getParentId() != null && comment.getParentId() != 0)
                .build();
    }
}
