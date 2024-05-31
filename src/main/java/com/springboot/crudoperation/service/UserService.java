package com.springboot.crudoperation.service;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserExistException;
import com.springboot.crudoperation.model.UserDto;

public interface UserService {

    UserDto findByUserName(String userName);

    UserDto signup(UserDto request);

    User login(UserDto request);
}
