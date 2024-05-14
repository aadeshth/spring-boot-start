package com.springboot.crudoperation.mapper;

import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.model.SchoolDto;

public class SchoolMapper {

    public static SchoolDto maptoSchoolDto(School school)
    {
        return SchoolDto.builder().name(school.getName()).id(school.getId()).address(school.getAddress()).dressCodeColors(school.getDressCodeColors()).createdBy(school.getCreatedBy()).updatedBy(school.getUpdatedBy()).createdDate(school.getCreatedDate()).updatedDate(school.getUpdatedDate()).build();
    }

}
