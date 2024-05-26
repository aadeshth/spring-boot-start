package com.springboot.crudoperation.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "ClassRoom")
@Table(name = "classroom_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class ClassRoom extends BaseEntity {

    String name;

    int grade;

    int floor;

    int strength;

}
