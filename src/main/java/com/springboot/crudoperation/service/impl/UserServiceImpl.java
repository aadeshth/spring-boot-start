package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserAuthException;
import com.springboot.crudoperation.exception.UserExistException;
import com.springboot.crudoperation.mapper.UserMapper;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.repository.UserRepository;
import com.springboot.crudoperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
         if(user == null)
             throw new UserAuthException("User Not Found!");
        return null;
    }

    @Override
    public UserDto signup(UserDto request) {
        User user = userRepository.findByUsername(request.getUsername());
        if(user != null)
            throw new UserExistException("User is present! Please enter different username!");
        User userForDB = UserMapper.mapToUser(request);
        userForDB.setPassword(passwordEncoder.encode(request.getPassword()));
        return UserMapper.mapToUserDto(userRepository.save(userForDB));
    }

    @Override
    public User login(UserDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),request.getPassword()));

        return  userRepository.findByUsername(request.getUsername());
    }

}
