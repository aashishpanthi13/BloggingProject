package com.example.blog.Service;

import com.example.blog.Entity.Blog;

public interface BlogService {
    Blog addBlog(Blog blog,Long userId);
    String deleteBlog(Long blogId,Long userId);
}
