package com.example.blog.Service;

import com.example.blog.Dto.BlogDto;
import com.example.blog.Entity.Blog;

import java.util.List;

public interface BlogService {
    Blog addBlog(Blog blog,Long userId);
    String deleteBlog(Long blogId,Long userId);
    BlogDto getById(Long blogId);
    List<BlogDto> getAll();
    List<BlogDto> getBlogByUserId(Long userId);

}
