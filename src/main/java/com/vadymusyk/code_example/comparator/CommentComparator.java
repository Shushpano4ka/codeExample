package com.vadymusyk.code_example.comparator;

import com.vadymusyk.code_example.dto.company.comment.DepartmentCommentDTO;
import com.vadymusyk.code_example.entity.company.comment.Comment;

import java.util.Comparator;

public class CommentComparator {

    public static Comparator<Comment> compareByCreateDate() {
        return (a, b) -> {
            if (a.getCreateDate().isAfter(b.getCreateDate())) {
                return -1;
            } else if (a.getCreateDate().isBefore(b.getCreateDate())) {
                return 1;
            } else return 0;
        };
    }

    public static Comparator<DepartmentCommentDTO> compareByCreateDateUNIX() {
        return (comment1, comment2) -> {
            if (comment1.getCreateDateUNIX() > comment2.getCreateDateUNIX()) {
                return -1;
            } else if (comment1.getCreateDateUNIX() < comment2.getCreateDateUNIX()) {
                return 1;
            } else return 0;
        };
    }
}
