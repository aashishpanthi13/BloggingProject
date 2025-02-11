package com.example.blog.Mapper;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.Comment;
import com.example.blog.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
@Mapping(target = "user" ,qualifiedByName ="noBlogs")
@Mapping(target = "commentReply", source = "commentReply") // Explicitly map commentReply
CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> repliesToRepliesDto(List<Comment> replies);


    @Named("noBlogs")
    @Mapping(target = "blogs",ignore = true)
    @Mapping(source = "username",target = "userName")
    UserDto userToUserDtoNoBlogs(User user);

}
