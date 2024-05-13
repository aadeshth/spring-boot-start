package com.springboot.crudoperation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
//@Table(name = "school")
@Getter
@Setter
public class School extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String address;
    List<String> dressCodeColors;

}
