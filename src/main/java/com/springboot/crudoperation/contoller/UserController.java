package com.springboot.crudoperation.contoller;

import com.springboot.crudoperation.exception.UserExistException;
import com.springboot.crudoperation.model.ResponseDto;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/auth")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    // auth/signup
    // auth/login
    // auth/logout

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signupUser(@RequestBody UserDto request) {
        UserDto res = userService.signup(request);
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Signup Successfully").data(res).build(), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDto request) {
        UserDto res = userService.login(request);
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Signup Successfully").data(res).build(), HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(@RequestBody UserDto request) {
        UserDto res = userService.logout(request);
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Signup Successfully").data(res).build(), HttpStatus.OK);
    }


}
