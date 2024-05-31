package com.springboot.crudoperation.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    String token;
    long expired;
}
