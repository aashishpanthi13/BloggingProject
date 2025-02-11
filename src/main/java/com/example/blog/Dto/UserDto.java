package com.example.blog.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class UserDto {
    private Long id;
    private String userName;
    private List<BlogDto> blogs;

}
