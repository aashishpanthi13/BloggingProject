package com.example.blog.Service;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    String addComment(Comment comment, Long blogId, Long parentId,Long userId);
    String deleteComment(Long commentId);

    CommentDto getCommentById(Long commentId);
    List<CommentDto> getAll();
    List<Map<String,Object>>getByBlogId(Long blogId);
    List<Map<String,Object>>getByUserId(Long userId);
}
