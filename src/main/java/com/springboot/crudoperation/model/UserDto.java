package com.springboot.crudoperation.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    String firstName;
    String lastName;
    String emailId;
    String username;
    String password;
}
