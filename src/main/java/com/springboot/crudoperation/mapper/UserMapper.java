package com.springboot.crudoperation.mapper;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.model.UserDto;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        return User.builder().username(userDto.getUsername()).firstName(userDto.getFirstName()).lastName(userDto.getLastName()).emailId(userDto.getEmailId()).password(userDto.getPassword()).build();
    }

    public static UserDto mapToUserDto(User user){
        return UserDto.builder().id(user.getId()).username(user.getUsername()).firstName(user.getFirstName()).lastName(user.getLastName()).emailId(user.getEmailId()).build();
    }
}
