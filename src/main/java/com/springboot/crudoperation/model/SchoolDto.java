package com.springboot.crudoperation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SchoolDto {
    Long id;
    String name;
    String address;
    List<String> dressCodeColors;


}
