package com.springboot.crudoperation.repository;

import com.springboot.crudoperation.entity.User;

public interface UserRepository {

    User findByUserName(String username);
}
