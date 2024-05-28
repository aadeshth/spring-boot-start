package com.springboot.crudoperation.service;

import com.springboot.crudoperation.exception.UserExistException;
import com.springboot.crudoperation.model.UserDto;

public interface UserService {

    UserDto findByUserName(String userName);

    UserDto signup(UserDto request);

    UserDto login(UserDto request);

    UserDto logout(UserDto request);
}
