package com.example.blog.Service;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Entity.Comment;

public interface CommentService {
    String addComment(Comment comment, Long blogId, Long parentId,Long userId);
    String deleteComment(Long commentId);

    CommentDto getComment(Long commentId);
}
