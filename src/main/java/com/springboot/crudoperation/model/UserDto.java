package com.springboot.crudoperation.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String emailId;
    String username;
    String password;
}
