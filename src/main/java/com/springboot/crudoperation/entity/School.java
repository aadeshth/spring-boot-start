package com.springboot.crudoperation.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.List;

@Entity(name = "School")
@Table(name = "school_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class School extends BaseEntity {
    String name;
    String address;
    String dressCodeColors;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "School_Id")
    List<ClassRoom> classRoomList;
}
