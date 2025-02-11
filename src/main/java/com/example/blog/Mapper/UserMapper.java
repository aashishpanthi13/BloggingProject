package com.example.blog.Mapper;

import com.example.blog.Dto.UserDto;
import com.example.blog.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses= BlogMapper.class,componentModel = "spring")
public interface UserMapper {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "username",target = "userName")

    UserDto userToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> users);
}
