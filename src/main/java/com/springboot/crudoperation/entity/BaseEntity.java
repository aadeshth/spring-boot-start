package com.springboot.crudoperation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Date createdDate;

    String createdBy;
    Date updatedDate;

    String updatedBy;

    int isDeleted;
}
