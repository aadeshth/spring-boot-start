package com.springboot.crudoperation.service;

import com.springboot.crudoperation.model.SchoolDto;


public interface SchoolService {

      SchoolDto saveSchool(SchoolDto schoolDto);
      SchoolDto updateSchool(SchoolDto schoolDto) ;

      SchoolDto findSchoolById(int schoolId);

      void deleteSchool(int schoolId);
}
