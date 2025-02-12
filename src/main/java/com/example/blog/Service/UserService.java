package com.example.blog.Service;

import com.example.blog.Dto.BlogDto;
import com.example.blog.Dto.CommentDto;
import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.Comment;
import com.example.blog.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
   User addUser(User user);
   UserDto getUserById(Long id);
   List<UserDto> getAllUsers();
   String deleteUserById(Long id);
   List<BlogDto> blogListByUserId(Long id);
   List<Map<String, Object>> getAllCommentsByUserId(Long id);


}
