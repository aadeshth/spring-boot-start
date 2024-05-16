package com.springboot.crudoperation.service;

import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.model.SearchRequest;

import java.util.List;


public interface SchoolService {

      SchoolDto saveSchool(SchoolDto schoolDto);
      SchoolDto updateSchool(SchoolDto schoolDto) ;

      SchoolDto findSchoolById(int schoolId);

      void deleteSchool(int schoolId);

      List<SchoolDto> findSchoolBySearchText(String searchText);
}
