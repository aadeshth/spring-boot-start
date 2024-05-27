package com.springboot.crudoperation.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.List;

@Entity(name = "School")
@Table(name = "School")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class School extends BaseEntity {
    String name;
    String address;
    String dressCodeColors;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    List<ClassRoom> classRoomList;
}
