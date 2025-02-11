package com.example.blog.Service;

import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.User;

import java.util.List;

public interface UserService {
   User addUser(User user);
   UserDto getUserById(Long id);
   List<UserDto> getAllUsers();
   String deleteUserById(Long id);


}
