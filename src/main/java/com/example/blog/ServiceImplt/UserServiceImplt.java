package com.example.blog.ServiceImplt;

import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.User;
import com.example.blog.Mapper.UserMapper;
import com.example.blog.Repo.UserRepo;
import com.example.blog.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplt implements UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);

    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return userMapper.userToUserDto(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.userListToUserDtoList(userRepo.findAll());
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return "User deleted";
        } else {
            throw new RuntimeException("User not found");
        }
    }


}

