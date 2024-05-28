package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserAuthException;
import com.springboot.crudoperation.exception.UserException;
import com.springboot.crudoperation.exception.UserExistException;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.repository.UserRepository;
import com.springboot.crudoperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
         if(user == null)
             throw new UserAuthException("User Not Found!");
        return null;
    }

    @Override
    public UserDto signup(UserDto request) {
        User user = userRepository.findByUserName(request.getUserName());
        if(user != null)
            throw new UserExistException("User is present! Please enter different username!");

        return null;
    }

    @Override
    public UserDto login(UserDto request) {
        return null;
    }

    @Override
    public UserDto logout(UserDto request) {
        return null;
    }
}
