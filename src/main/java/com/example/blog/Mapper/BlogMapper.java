package com.example.blog.Mapper;

import com.example.blog.Dto.BlogDto;
import com.example.blog.Entity.Blog;
import com.example.blog.Entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses= CommentMapper.class,componentModel = "spring")
public interface BlogMapper {
    BlogMapper blogMapper = Mappers.getMapper(BlogMapper.class);
    BlogDto blogToBlogDto(Blog blog);
    List<BlogDto> blogListToBlogDtoList(List<Blog> blogList);
}
