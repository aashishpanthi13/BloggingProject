package com.example.blog.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CommentDto {
    private Long id;
    private String commentBody;
    private UserDto user;
    private List<CommentDto> commentReply;
}
