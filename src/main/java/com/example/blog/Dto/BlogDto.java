package com.example.blog.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class BlogDto {
    private Long id;
    private String blogBody;
    private List<CommentDto> comments;

}
