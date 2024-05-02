package com.springboot.crudoperation.service;

import com.springboot.crudoperation.model.School;

public interface SchoolService {

      void saveSchool();
      School findSchoolById(int schoolId);
}
