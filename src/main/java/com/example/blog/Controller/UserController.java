package com.example.blog.Controller;

import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.User;
import com.example.blog.Mapper.UserMapper;
import com.example.blog.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
