package com.springboot.crudoperation.exception.handler;

import com.springboot.crudoperation.exception.*;
import com.springboot.crudoperation.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleSchoolNotFoundException(DataNotFoundException exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> exception(Exception exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> requestValidationException(RequestValidationException exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.BAD_REQUEST.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> userUnauthorizedException(UserException exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> userUnauthorizedException(UserAuthException exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.UNAUTHORIZED.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<?> userExistExceptionException(UserExistException exception){
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.NOT_ACCEPTABLE.value()).message(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    }
}
