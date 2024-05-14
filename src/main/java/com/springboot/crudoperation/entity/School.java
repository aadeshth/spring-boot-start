package com.springboot.crudoperation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity(name = "school_tbl")
//@Table(name = "school_tbl")
@Getter
@Setter
public class School extends BaseEntity {
    String name;
    String address;
    List<String> dressCodeColors;

}
