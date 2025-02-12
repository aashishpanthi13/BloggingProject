package com.example.blog.Controller;

import com.example.blog.Dto.BlogDto;
import com.example.blog.Dto.CommentDto;
import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.Comment;
import com.example.blog.Entity.User;
import com.example.blog.Mapper.UserMapper;
import com.example.blog.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user/")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/getById")
    public ResponseEntity<UserDto> getUserById(@RequestParam("id") Long id) {
       UserDto userDto = userService.getUserById(id);
       return new ResponseEntity<>(userDto, HttpStatus.FOUND);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDto = userService.getAllUsers();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteUserById(@RequestParam("id") Long id) {
        UserDto userDto =  userService.getUserById(id);
      userService.deleteUserById(id);
      return new ResponseEntity<>("User deleted", HttpStatus.OK);

    }
    @GetMapping("/getBlogByUserId")
    public ResponseEntity<List<BlogDto>> getBlogByUserId(@RequestParam("userId") Long userId) {
        List<BlogDto> blogDtos = userService.blogListByUserId(userId);
        return new ResponseEntity<>(blogDtos, HttpStatus.OK);
    }
    @GetMapping("/getCommentByUserId")
    public ResponseEntity<List<Map<String, Object>>> getCommentByUserId(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(userService.getAllCommentsByUserId(userId), HttpStatus.OK);
    }

}
