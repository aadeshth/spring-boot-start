package com.springboot.crudoperation.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class BaseEntity {

    Date createdDate;

    String createdBy;
    Date updatedDate;

    String updatedBy;
}
